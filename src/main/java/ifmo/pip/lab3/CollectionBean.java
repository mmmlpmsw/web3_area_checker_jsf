package ifmo.pip.lab3;

import org.hibernate.Query;
import org.hibernate.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

@ManagedBean
@SessionScoped
public class CollectionBean {
    @SuppressWarnings("unchecked")
    public List<Point> getPoints(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createCriteria(Point.class).list();
    }

    public void addPoint(Point point) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(point);
        session.getTransaction().commit();
    }
}

//    mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar -Dfile=custom_libs/ojdbc8.jar -DgeneratePom=true -DlocalRepositoryPath=repo
