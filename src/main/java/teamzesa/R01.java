package teamzesa;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import teamzesa.util.IOHandler.Announcer;
import teamzesa.event.EventRegisterSection;
import teamzesa.util.Enum.CommandListup;
import teamzesa.util.IOHandler.ConfigIOHandler;
import teamzesa.util.userHandler.UserIOHandler;
import teamzesa.util.ThreadPool;


public final class R01 extends JavaPlugin {
    private final String PLUGIN_NAME = "[R01]";
    private final long RUNNING_TIME;

    public R01() {
        this.RUNNING_TIME = System.currentTimeMillis();
    }

    @Override
    public void onEnable() {
        eventAndFunctionRegister();   //command set
//        autoSaveSchedule(); // User Data Auto Save Scheduling

//        saveDefaultSource
        if (!getDataFolder().exists())
            generationDataFile();

//        configSet
        fileLoader(); // config set File

//        loading Time
        pluginLoadTime();
    }

    @Override
    public void onDisable() {
        UserIOHandler.exportUserData();
        ThreadPool.getThreadPool().allServiceOff();
        Bukkit.getScheduler().cancelTasks(this);
    }

    public void fileLoader() {
//        config Set
        ConfigIOHandler configIOHandler = ConfigIOHandler.getConfigIOHandler();
        configIOHandler.fileLoader();
        configIOHandler.allConfigLoad(); //config Load

//        import userData
        UserIOHandler.importUserData();

//        Announcer Set
        Announcer.getAnnouncer().defaultAnnouncer();
    }

    private void eventAndFunctionRegister() {
        getServer().getPluginManager().registerEvents(new EventRegisterSection(), this); //function set

        for (CommandListup commandEnum : CommandListup.values()) //command set
            getCommand(commandEnum.getCommand()).setExecutor(commandEnum.newInstance());
    }

    private void autoSaveSchedule() {
        long delay = 0;
        long interval = 720; // 12hour term auto save
        ThreadPool.getThreadPool().addSchedulingTask(
                UserIOHandler::exportUserData,
                delay,
                interval
        );
        Bukkit.getLogger().info(PLUGIN_NAME + " Success Scheduling All User Data Save");
    }

    private void pluginLoadTime() {
        String blockingTime = String.format("(%.3fs)",
                (System.currentTimeMillis() - this.RUNNING_TIME)/1000.0
        );
        Bukkit.getLogger().info(PLUGIN_NAME + " Done " + blockingTime);
    }

    private void generationDataFile() {
        saveDefaultConfig(); // config Data
        saveResource("userData.json" ,false); // userData
        Bukkit.getLogger().info(PLUGIN_NAME + " Plugin Data File 생성 완료.");
    }

}
