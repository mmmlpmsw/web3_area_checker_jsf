package ifmo.pip.lab3;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "POINTS")
public class Point implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "x", nullable = false)
    private Double x;
    @Column(name = "y", nullable = false)
    private Double y;
    @Column(name = "r", nullable = false)
    private Double r;
    @Column(name = "ch", nullable = false)
    private Boolean isCheck;

    public Point() {

    }


    public Double getR() {
        return r;
    }
    public void setR(Double r) {
        this.r = r;
    }

    public Double getX() {
        return x;
    }
    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }
    public void setY(Double y) {
        this.y = y;
    }

    public Boolean getIsCheck() {
        return isCheck;
    }
    public void setIsCheck(Boolean isCheck) {
        this.isCheck = isCheck;
    }
}
