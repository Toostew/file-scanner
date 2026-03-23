package com.toostew.file_scanner.DAO;



//first time using generics
//in java generics, <T> is declaring the generic object T within <>
//we can now use T anywhere to represent generic classes, methods etc
//so when implementing GenericDAO, we can specify what we are working with like:
// Example implements GenericDAO<ExampleClass>
public interface GenericDAO<T> {

    public void create(T t);
    public T get(int id);
    public void update(T t);
    public void delete(int id);

}
