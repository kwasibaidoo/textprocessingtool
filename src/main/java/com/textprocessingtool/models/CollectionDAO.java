package com.textprocessingtool.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CollectionDAO {
    private static CollectionDAO instance;
    private final HashMap<Integer, DataCollection> collectionMap = new HashMap<>();
    private int nextId = 1;


    public static CollectionDAO getInstance(){
        if(instance == null){
            instance = new CollectionDAO();
        }
        return instance;
    }

    
    public void save(DataCollection dataCollection) {
        dataCollection.setId(nextId++);
        collectionMap.put(dataCollection.getId(), dataCollection);
    }

    
    public List<DataCollection> findAll() {
        return new ArrayList<>(collectionMap.values());
    }

    
    public DataCollection findById(int id) {
        return collectionMap.get(id);
    }

    
    public boolean deleteById(int id) {
        return collectionMap.remove(id) != null;
    }
}
