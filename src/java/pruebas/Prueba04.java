
package pruebas;

import java.util.Iterator;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class Prueba04 {
    
    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        String q = "select d.iddepartamento, d.departamento "
                + "from Departamentos d";
        
        Query query = session.createQuery(q);
        Iterator it = query.iterate();
        
        while (it.hasNext()) {
            Object[] o = (Object[])(Object)it.next();
            
            for (int col = 0; col < o.length; col++) {
                System.out.println(o[col].toString() + "\t");
            }
            System.out.println();
        }
        session.close();
    }
    
}
