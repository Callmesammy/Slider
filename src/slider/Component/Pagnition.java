
package slider.Component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;


public class Pagnition {
    private int index;
    private int currentIndex;
    private EventPagnition event;

    public void addEventPagnition(EventPagnition event){
        this.event = event;            
        }
    
    public void addIndex(int index){
        this.index = index;
    }
    
    public void addCurrentIndex(int currentIndex){
        this.currentIndex = currentIndex;
    }
    
    public Pagnition() {
    }
    
    public void Total(){
        
    }
    
    public class Item extends JButton{

        public Item(EventPagnition event, int index) {
            setContentAreaFilled(false);
            setBorder(new EmptyBorder(5,5,5,5)); 
            setBackground(Color.white);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                event.Onclick(index);
                }
            });
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
        
        }
        
        
    }
    
}
