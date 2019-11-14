package ifmo.pip.lab3;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.io.IOException;

@ManagedBean
@RequestScoped
public class PointBean {
    private double x;
    private double y;
    private double r;

    @ManagedProperty("#{collectionBean}")
    private CollectionBean collectionBean;

    public void setR(double r) {
        this.r = r;
    }
    public double getR() {
        return r;
    }

    public void setX(double x) {
        this.x = x;
    }
    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public double getY() {
        return y;
    }

    public void valX(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {

            double x = Double.parseDouble(o.toString().replace(',', '.'));

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("X validation failed.", "Неверная координата Х.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }


    public CollectionBean getCollectionBean() {
        return collectionBean;
    }

    public void setCollectionBean(CollectionBean collectionBean) {
        this.collectionBean = collectionBean;
    }

    public boolean check() {
        if ((x >= 0 && y <= 0 && x*x + y*y <= r*r) ||
                (x <= 0 && y <= 0 && x >= -r && y >= -r) ||
                (x >= 0 && y >= 0 && y <= (-x + r)))
            return true;
        else
            return false;
    }

    public void create() throws IOException {
        Point point = new Point();

        point.setX(x);
        point.setY(y);
        point.setR(r);
        point.setIsCheck(check());
        collectionBean.addPoint(point);
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
}
