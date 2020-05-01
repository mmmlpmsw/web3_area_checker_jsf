import ifmo.pip.lab3.PointBean;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    // exactly inside
    @Test
    public void testInsideTriangle() {
        PointBean pointBean = new PointBean();
        pointBean.setX(1);
        pointBean.setY(0.1);
        pointBean.setR(2);
        assertTrue("Check point(1; 0) with R = 2", pointBean.check());
    }

    @Test
    public void testInsideRectangle() {
        PointBean pointBean = new PointBean();
        pointBean.setX(0.5);
        pointBean.setY(-0.3);
        pointBean.setR(2);
        assertTrue("Check point(-0.5; -0.3) with R = 2", pointBean.check());
    }

    @Test
    public void testInsideCircle() {
        PointBean pointBean = new PointBean();
        pointBean.setX(-1);
        pointBean.setY(-1.11);
        pointBean.setR(2);
        assertTrue("Check point(-1; -1.11) with R = 2", pointBean.check());
    }

    // far away from borders
    @Test
    public void testOutside() {
        PointBean pointBean = new PointBean();
        pointBean.setX(-1.2);
        pointBean.setY(4);
        pointBean.setR(3);
        assertFalse("Check point(-1.2; 4) with R = 3", pointBean.check());
    }

    @Test
    public void testOutsideTriangle() {
        PointBean pointBean = new PointBean();
        pointBean.setX(1.1);
        pointBean.setY(0.2);
        pointBean.setR(0.5);
        assertFalse("Check point(1.1; 0) with R = 0.5", pointBean.check());
    }

    @Test
    public void testOutsideRectangle() {
        PointBean pointBean = new PointBean();
        pointBean.setX(2.001);
        pointBean.setY(4);
        pointBean.setR(2);
        assertFalse("Check point(2.001; 4) with R = 2", pointBean.check());
    }

    @Test
    public void testOutsideCircle() {
        PointBean pointBean = new PointBean();
        pointBean.setX(-1);
        pointBean.setY(-3);
        pointBean.setR(3);
        assertFalse("Check point(-1; -1.5) with R = 3", pointBean.check());
    }

    //borders
    @Test
    public void testTriangleBorder() {
        PointBean pointBean = new PointBean();
        pointBean.setX(1);
        pointBean.setY(0.5);
        pointBean.setR(2);
        assertTrue("Check point(1; 0.5) with R = 2", pointBean.check());
    }

    @Test
    public void testRectangleBorder() {
        PointBean pointBean = new PointBean();
        pointBean.setX(2.2);
        pointBean.setY(-0.8);
        pointBean.setR(2.2);
        assertTrue("Check point(2.2; -0.8) with R = 2.2", pointBean.check());
    }

    @Test
    public void testCircleBorder() {
        PointBean pointBean = new PointBean();
        pointBean.setX(-1);
        pointBean.setY(-Math.sqrt(3));
        pointBean.setR(2);
        assertTrue("Check point(-1; -sqrt(3)) with R = 2", pointBean.check());
    }

    @Test
    public void testBetweenRectangleAndCircleBorder() {
        PointBean pointBean = new PointBean();
        pointBean.setX(0);
        pointBean.setY(-1.5);
        pointBean.setR(2);
        assertTrue("Check point(0; -1.5) with R = 2", pointBean.check());
    }

    @Test
    public void testBetweenEmptyAndCircleBorder() {
        PointBean pointBean = new PointBean();
        pointBean.setX(-1);
        pointBean.setY(0);
        pointBean.setR(2);
        assertTrue("Check point(-1; 0) with R = 2", pointBean.check());
    }
    @Test
    public void testBetweenEmptyAndTriangleBorder() {
        PointBean pointBean = new PointBean();
        pointBean.setX(0);
        pointBean.setY(0.9);
        pointBean.setR(2);
        assertTrue("Check point(0; 0.9) with R = 2", pointBean.check());
    }

    // outside, but close to the border
    @Test
    public void testOutsideTriangleBorder() {
        PointBean pointBean = new PointBean();
        pointBean.setX(1);
        pointBean.setY(0.500001);
        pointBean.setR(2);
        assertFalse("Check point(1; 0.500001) with R = 2", pointBean.check());
    }

    @Test
    public void testOutsideRectangleBorder() {
        PointBean pointBean = new PointBean();
        pointBean.setX(2.200001);
        pointBean.setY(-0.8);
        pointBean.setR(2.2);
        assertFalse("Check point(2.200001; -0.8) with R = 2.2", pointBean.check());
    }

    @Test
    public void testOutsideCircleBorder() {
        PointBean pointBean = new PointBean();
        pointBean.setX(-1);
        pointBean.setY(-Math.sqrt(3.00001));
        pointBean.setR(2);
        assertFalse("Check point(-1; -sqrt(3.00001)) with R = 2", pointBean.check());
    }

    @Test(expected = NumberFormatException.class)
    public void testNonDoubleX() {
        PointBean pointBean = new PointBean();
        pointBean.setX(Double.parseDouble("aaaa"));
    }

    @Test(expected = NumberFormatException.class)
    public void testEmptyX() {
        PointBean pointBean = new PointBean();
        pointBean.setX(Double.parseDouble(""));
    }

    @Test(expected = NumberFormatException.class)
    public void testNonDoubleY() {
        PointBean pointBean = new PointBean();
        pointBean.setY(Double.parseDouble("aaaaa"));
    }

    @Test(expected = NumberFormatException.class)
    public void testEmptyY() {
        PointBean pointBean = new PointBean();
        pointBean.setY(Double.parseDouble(""));
    }

    @Test(expected = NumberFormatException.class)
    public void testEmptyR() {
        PointBean pointBean = new PointBean();
        pointBean.setR(Double.parseDouble(""));
    }

    @Test(expected = NumberFormatException.class)
    public void testNonDoubleR() {
        PointBean pointBean = new PointBean();
        pointBean.setR(Double.parseDouble("aaaaaa"));
    }

}