package nandes.workshop.model.dao;


import nandes.workshop.model.entities.Department;
import nandes.workshop.model.entities.Seller;

import java.util.List;

public interface SellerDao {

    void insert(Seller obj);

    void update(Seller obj);

    void deleteById(Integer id);

    Seller findById(Integer id);

    List<Seller> findAll();

    List<Seller> findByDepartmentId(Department department);
}
