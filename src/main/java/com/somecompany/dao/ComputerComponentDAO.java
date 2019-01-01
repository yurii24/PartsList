package com.somecompany.dao;

import com.somecompany.entity.ComputerComponent;
import org.hibernate.query.Query;

import java.util.List;

public interface ComputerComponentDAO {

    List<ComputerComponent> getComponents(String strQuery);

    List<ComputerComponent> getComponents(String strQuery, int page);

    void saveComponent(ComputerComponent component);

    ComputerComponent getComponent(int id);

    void deleteComponent(int id);
}
