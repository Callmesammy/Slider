
package slider.Component;

import java.awt.Component;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author user
 */
/**
 *
 * @author user
 */
public class Slide extends javax.swing.JLayeredPane {

    private final MigLayout layout;
    private final JPanel panel;
    private final Animator animate;
    private Component componentShow;
    private Component componentOut;
    private boolean selected;
    private int Selectedindex;
    
    public Slide() {
    layout = new MigLayout("inset 0");
    panel = new JPanel();
    TimingTarget target = new TimingTargetAdapter(){
        @Override
        public void begin() {
       componentShow.setVisible(true);
       componentOut.setVisible(true);
        }

        @Override
        public void timingEvent(float fraction) {
        double width = panel.getWidth();
        int location = (int) (width * fraction);
        int locationShow = (int) (width * (1f - fraction));
            if (selected) {
                layout.setComponentConstraints(componentShow, "pos " +locationShow+ " 0 100% 100%, w 100%!");
                layout.setComponentConstraints(componentOut, "pos -" +location+ " 0 " +(width -location) + " 100%");
                
            }else{
                 layout.setComponentConstraints(componentShow, "pos -" +locationShow+ " 0 " +(width -locationShow)+ " 100%");
                layout.setComponentConstraints(componentOut, "pos " +location+ " 0 100% 100%, width 100%!");
               
              
            }
            panel.revalidate();
        }

        @Override
        public void end() {
        componentOut.setVisible(false);
        layout.setComponentConstraints(componentOut, "pos 0 0 100% 100%, width 100%");
        }
        
    };
    animate = new Animator(1000, target);
    animate.setResolution(0);
    animate.setAcceleration(0.5f);
    animate.setDeceleration(0.5f);
    panel.setLayout(layout);
    setLayout(new MigLayout("fill, inset 0", "[fill, center]", "3[fill]3"));
        add(panel, " w 100%-6!");
    }
    
    public void getSlider(Component ...com){
        if (com.length >=2) {
            for(Component coms: com){
                coms.setVisible(false);
                panel.add(coms, "pos 0 0 0 0");        
        }   
            if (panel.getComponentCount() > 0) {
                componentShow = panel.getComponent(0);
                componentShow.setVisible(true);
                layout.setComponentConstraints(componentShow, "pos 0 0 100% 100%");
            }
            
        
        }
    }

   
 
    public void selected(){
        if (!animate.isRunning()) {
            selected = true;
            Selectedindex = getSelected(Selectedindex);
            componentShow = panel.getComponent(Selectedindex);
            componentOut = panel.getComponent(checkSelected(Selectedindex-1));
            animate.start();
        }
    }
    private int getSelected (int index){
        if (index == panel.getComponentCount()-1) {
            return 0;
        }else{
            return index +1;
        }
    }
    public void Back(){
        if (!animate.isRunning()) {
            selected = false;
            Selectedindex = goBack(Selectedindex);
            componentShow = panel.getComponent(Selectedindex);
            componentOut = panel.getComponent(checkBack(Selectedindex +1));
            animate.start();
        }
    }
    
    private int checkSelected(int index){
        if (index == -1) {
            return panel.getComponentCount() -1;
        }else{
            return index;
        }
    }
    
    private int goBack(int index){
        if (index == 0) {
            return panel.getComponentCount() -1;
        }else{
            return index -1;
        }
    }
    
    private int checkBack(int index){
        if (index == panel.getComponentCount()) {
            return 0;
        }else{
            return index;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
