package teamzesa.DataBase.userHandler;

import teamzesa.DataBase.UAO;
import teamzesa.DataBase.entity.User;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserAccessObject implements UAO<UUID,User> {

    private static final ConcurrentHashMap<UUID,User> USER_DATA = new ConcurrentHashMap<>();

    private static class UaoHolder {
        private final static UserAccessObject INSTANCE = new UserAccessObject();
    }

    public static UserAccessObject getInstance() {
        return UaoHolder.INSTANCE;
    }


    public synchronized ConcurrentHashMap<UUID,User> getAllUserTable() {
        return new ConcurrentHashMap<>(USER_DATA);
    }

    @Override
    public synchronized boolean insert(User user) {
        USER_DATA.put(user.uuid(), user);
        return Boolean.TRUE;
    }

    @Override
    public synchronized User select(UUID uuid) {
        return USER_DATA.get(uuid);
    }

    @Override
    public synchronized Boolean update(User user) {
        USER_DATA.replace(user.uuid(), user);
        return Boolean.TRUE;
    }

    @Override
    public synchronized Boolean clear() {
        USER_DATA.clear();
        return Boolean.TRUE;
    }
}
