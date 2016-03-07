
package pruebas;

import java.util.Iterator;
import model.Departamentos;
import model.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

public class Prueba01 {
    
    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        String s = "from Departamentos";
        Query query = session.createQuery(s);
        Iterator it = query.iterate();
        
        while (it.hasNext()) {
            Departamentos departamentos = (Departamentos) it.next();
            System.out.println(
                    departamentos.getIddepartamento() + " - "
                    + departamentos.getDepartamento());
        }
        
        session.close();
    }
    
}
