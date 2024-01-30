package hei.school.wallet.api.operation;

import java.util.List;

public interface CrudOperations<T> {
    List<T> findAll();

    T findById(String id);
}
