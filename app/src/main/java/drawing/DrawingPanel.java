package drawing;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawingPanel extends JPanel {
        private Color penColor = Color.BLACK; // Default pen color
        private Point prevPoint = null;
        // getGraphics() is a method inherited from java.lang.Component which is a 
        // class immediately under java.lang.Object;
        // https://docs.oracle.com/javase/8/docs/api/java/awt/Component.html 
        
       private MouseListener mousePressedListener;

        public DrawingPanel(JTextField textField0, JTextField textField1) {
            // Creating Listeners below in two ways:
            // 1: For mousePressed events, define mousePressedListener separately and then pass to addMouseListener().
            // 2: For mouseDragged events, define listener in-line with the call to addMouseListener() 
            mousePressedListener = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int clickcount = e.getClickCount();
                    int button = e.getButton();

                    switch(button) {
                        case 1: // left button
                            if (clickcount >= 2) 
                                try {
                                    drawRectangle(e,Integer.parseInt(textField0.getText()),Integer.parseInt(textField1.getText()));
                                } catch (NumberFormatException exception) {
                                    drawText(e,"One of the text fields is not a number!");
                                }
                            else
                                prevPoint = e.getPoint();
                        break;

                        case 2: // middle button
                            drawOval(e,Integer.parseInt(textField0.getText()),Integer.parseInt(textField1.getText()));
                        break;
                        
                        case 3:
                        default:
                            drawText(e,textField0.getText());
                            break;
                    }
                }
            };

            addMouseListener(mousePressedListener);

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    drawLine(e);
                }
            });
        }
        // Draw text method
        protected void drawText(MouseEvent e, String text) {
                Graphics g = getGraphics();
                g.setColor(penColor);
                g.drawString(text,e.getX(),e.getY());
                prevPoint = e.getPoint();
                g.dispose();
        }
        // Draw circle method
        protected void drawOval(MouseEvent e, int major, int minor) {
                Graphics g = getGraphics();
                g.setColor(penColor);
                g.drawOval(e.getX()-major/2, e.getY()-minor/2, major,minor);
                prevPoint = e.getPoint();
                g.dispose();
        }

        // Draw line method
        protected void drawLine(MouseEvent e) {
            if (prevPoint != null) {
                Graphics g = getGraphics();
                g.setColor(penColor);
                g.drawLine(prevPoint.x, prevPoint.y, e.getX(), e.getY());
                prevPoint = e.getPoint();
                g.dispose();
            }
        }

            // Draw rectangle method
            protected void drawRectangle(MouseEvent e,int height, int width) {
            if (prevPoint != null) {
                Graphics g = getGraphics();
                g.setColor(penColor);
                g.drawRect(prevPoint.x, prevPoint.y, height, width);
                prevPoint = e.getPoint();
                g.dispose();
            }
        }

        public Color getPenColor() {
            return penColor;
        }

        public void setPenColor(Color color) {
            this.penColor = color;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }

    }
