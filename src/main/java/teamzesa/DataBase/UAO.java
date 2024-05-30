package teamzesa.DataBase;

import teamzesa.DataBase.entity.User;

public interface UAO<K,E> {

    boolean insert(E e);

    User select(K k);

    Boolean update(E e);

    Boolean clear();
}
