package com.example.memoryDB.db;

import com.example.memoryDB.Entitiy.Entity;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

abstract public class SimpleDataRepository<T extends Entity, ID extends Long> implements dataRepository<T, ID> {
    private List<T> dataList = new ArrayList<T>();

    private static long index = 0;

    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {

            return Long.compare(o1.getId(), o2.getId());
        }
    };

    //create, update

    @Override
    public T save(T data) {

        if(Objects.isNull(data)){
            throw new RuntimeException("DATA IS NULL!");
        }

        //db에 데이터가 있는지
        var prevData = dataList.stream()
            .filter(it->{
                return it.getId().equals(data.getId());
            })
            .findFirst();
        if(prevData.isPresent()){
            //있는경우
            dataList.remove(prevData.get());
            dataList.add(data);
        }else{
            //데이터가 없는경우
            data.setId(index);
            dataList.add(data);
            index++;
        }

        return data;
    }


    //read
    @Override
    public Optional<T> findById(ID id){
        return dataList.stream()
            .filter(it->{
                return (it.getId().equals(id));
            })
            .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }

    //delete
    @Override
    public void delete(ID id){
        var deleteEntity = dataList.stream()
                .filter(it->{
                    return (it.getId().equals(id));
                })
                .findFirst();

        if(deleteEntity.isPresent()){
            dataList.remove(deleteEntity.get());
        }
    }
}
