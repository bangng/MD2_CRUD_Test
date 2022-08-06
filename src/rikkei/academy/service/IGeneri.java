package rikkei.academy.service;

import java.util.List;

public interface IGeneri <E>{
    List<E> findall();
    void save(E element);
//    void update(E element);
//    void deLete(E element);

}
