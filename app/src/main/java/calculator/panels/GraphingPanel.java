package calculator.panels;

import javax.swing.*;
import java.awt.*;
import java.util.function.Function;

import calculator.utilities.*;

public class GraphingPanel extends JPanel {

    public GraphingPanel() {
        setPreferredSize(new Dimension(450, 400));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(UIColors.displayColor);

        g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 50, 50);

        drawAxis(g2);

        plotCurve(g2, Math::sin, -Math.PI, Math.PI, UIColors.equalColor);
        plotCurve(g2, Math::cos, -Math.PI, Math.PI, UIColors.trigOpColor);
        plotCurve(g2, Math::tan, -Math.PI, Math.PI, UIColors.trascendentalColor);
        // plotCurve(g2, Math::asin, -Math.PI, Math.PI, UIColors.equalColor);
        // plotCurve(g2, Math::acos, -Math.PI, Math.PI, UIColors.trigOpColor);
        // plotCurve(g2, Math::atan, -Math.PI, Math.PI, UIColors.trascendentalColor);
    }

    private void drawAxis(Graphics2D g2) {
        int middlePX = getWidth() / 2; // midlepoint
        int middlePY = getHeight() / 2;

        int endPointX = 5;
        int endPointY = 5;

        int endPointX2 = getWidth() - 5; // 5 is the current padding
        int endPointY2 = getHeight() - 5; // 5 is the current padding

        g2.setStroke(new BasicStroke(2));

        // draws x axis
        g2.setColor(UIColors.oddnumberColor);
        g2.drawLine(endPointX, middlePY, endPointX2, middlePY);
        // draws y axis
        g2.drawLine(middlePX, endPointY, middlePX, endPointY2);

        // haardcode sin for testing
        // g2.setColor(UIColors.equalColor);
        // for (int x = -360; x < 360; x++) {
        // int y1 = (int) (middlePY - 50 * Math.sin(Math.toRadians(x)));
        // int y2 = (int) (middlePY - 50 * Math.sin(Math.toRadians(x + 1)));
        // g2.drawLine(middlePX + x, y1, middlePX + x + 1, y2);
        // }

    }

    private void plotCurve(Graphics2D g2, Function<Double, Double> function, double xStart, double xEnd, Color color) {
        g2.setColor(color); // color
        double scaleX = 0.9 * ((getWidth()) / (xEnd - xStart));
        double scaleY = 0.9 * ((getHeight()) / 2);
        // i need a yStart and yEnd

        // startpoint
        double initX = xStart;
        double initY = function.apply(initX);

        int prevX = (int) (scaleX * (initX - xStart) + (getWidth() - scaleX * (xEnd - xStart)) / 2); // Centering the
                                                                                                     // plot
                                                                                                     // horizontally
        int prevY = (int) ((getHeight() / 2) - (scaleY * initY)); // Centering vertically

        // int prevX = (int) (scaleX * (0 - xStart));
        // int prevY = (int) (scaleY - scaleY * function.apply(0.0));

        for (double x = xStart; x <= xEnd; x += 0.01) { // Increase resolution as needed default:0.01
            int currentX = (int) (scaleX * (x - xStart) + (getWidth() - scaleX * (xEnd - xStart)) / 2);
            double yValue = function.apply(x);
            int currentY = (int) ((getHeight() / 2) - (scaleY * yValue));
            g2.drawLine(prevX, prevY, currentX, currentY);
            prevX = currentX;
            prevY = currentY;
        }
    }

}
