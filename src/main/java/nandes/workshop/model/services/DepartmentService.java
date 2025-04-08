package nandes.workshop.model.services;

import nandes.workshop.model.dao.DaoFactory;
import nandes.workshop.model.dao.DepartmentDao;
import nandes.workshop.model.entities.Department;

import java.util.List;

public class DepartmentService {

    private DepartmentDao dao = DaoFactory.createDepartmentDao();

    public List<Department> findAll(){
        return dao.findAll();
    }
}
