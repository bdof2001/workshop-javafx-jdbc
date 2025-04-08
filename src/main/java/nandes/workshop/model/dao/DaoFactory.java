package nandes.workshop.model.dao;


import nandes.workshop.db.DB;
import nandes.workshop.model.dao.impl.DepartmentDaoJDBC;
import nandes.workshop.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
