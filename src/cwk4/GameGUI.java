package cwk4;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * Provide a GUI interface for the game
 * 
 * @author A.A.Marczyk
 * @version 20/01/24
 */
public class GameGUI 
{
    private CARE gp = new Tournament("Fred", "challengesAM.txt");
    private JFrame myFrame = new JFrame("Game GUI");
    private JTextArea listing = new JTextArea();
    private JLabel codeLabel = new JLabel ();
    private JButton meetBtn = new JButton("Meet Challenge");
    private JButton viewBtn = new JButton("View State");
    private JButton clearBtn = new JButton("Clear");
    private JButton quitBtn = new JButton("Quit");
    private JPanel eastPanel = new JPanel();

    public static void main(String[] args)
    {
        new GameGUI();
    }
    
    public GameGUI()
    {
        makeFrame();
        makeMenuBar(myFrame);
    }
    

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {    
        myFrame.setLayout(new BorderLayout());
        myFrame.add(listing,BorderLayout.CENTER);
        listing.setVisible(false);
        myFrame.add(eastPanel, BorderLayout.EAST);
        // set panel layout and add components
        eastPanel.setLayout(new GridLayout(4,1));
        eastPanel.add(meetBtn);
        eastPanel.add(clearBtn);
        eastPanel.add(quitBtn);

        eastPanel.add(viewBtn);
        
        clearBtn.addActionListener(new ClearBtnHandler());
        meetBtn.addActionListener(new MeetBtnHandler());
        quitBtn.addActionListener(new QuitBtnHandler());


        viewBtn.addActionListener(new ViewButtonHandler());
        
        meetBtn.setVisible(true);
        clearBtn.setVisible(true);
        quitBtn.setVisible(true);

        viewBtn.setVisible(true);

        // building is done - arrange the components and show        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the File menu
        JMenu championMenu = new JMenu("Champions");
        menubar.add(championMenu);
        
        JMenuItem listChampionItem = new JMenuItem("List Champions in reserve");
        listChampionItem.addActionListener(new ListReserveHandler());
        championMenu.add(listChampionItem);

        JMenuItem viewChampion = new JMenuItem("View a champion");
        viewChampion.addActionListener(new viewChamphandler());
        championMenu.add(viewChampion);

        JMenuItem enterChamp = new JMenuItem("Enter a champion");
        enterChamp.addActionListener(new enterChampionHandler());
        championMenu.add(enterChamp);

        JMenuItem listTeam = new JMenuItem("List champions in team");
        championMenu.add(listTeam);
        listTeam.addActionListener(new listTeamHandler());


    }

    private class ListReserveHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setVisible(true);
            String xx = gp.getReserve();
            listing.setText(xx);
        }
    }
    
   
    private class ClearBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setText(" ");
        }
    }
    
    private class MeetBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int result = -1;
            String answer = "no such challenge";
            String inputValue = JOptionPane.showInputDialog("Challenge number ?: ");
            int num = Integer.parseInt(inputValue);
            result = gp.meetChallenge(num);
            switch (result)
            {
                case 0:answer = "challenge won by champion"; break;
                case 1:answer = "challenge lost on skills, champion disqualified";break;
                case 2:answer = "challenge lost as no suitable champion is available";break;
                case 3:answer = "challenge lost and vizier completely defeated";break;
            }
            
            JOptionPane.showMessageDialog(myFrame,answer);    
        }
    }
    
    private class QuitBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int answer = JOptionPane.showConfirmDialog(myFrame,
                "Are you sure you want to quit?","Finish",
                JOptionPane.YES_NO_OPTION);
            // closes the application
            if (answer == JOptionPane.YES_OPTION)
            {
                System.exit(0); //closes the application
            }              
        }
    }

    private class viewChamphandler implements ActionListener{

        public void actionPerformed(ActionEvent e){
            String champName = JOptionPane.showInputDialog("Enter the champion name: ");
            String xx = GameGUI.this.gp.getChampionDetails(champName);
            JOptionPane.showMessageDialog(GameGUI.this.myFrame, xx);
        }
    }

    private class enterChampionHandler implements ActionListener{

        public void actionPerformed(ActionEvent e){
            StringBuilder result = new StringBuilder();
            String champName = JOptionPane.showInputDialog("Enter Champion name: ");
            int returnValue = GameGUI.this.gp.enterChampion(champName);
            if(returnValue==0){
                result.append("Champion entered into team");
            }
            else if(returnValue==1){
                result.append("Champion not in reserve");
            }
            else if(returnValue==2){
                result.append("You dont have enough money");
            }
            else{
                result.append("No such Champion");
            }

            result.append("\nTreasury = £" + GameGUI.this.gp.getMoney());


            JOptionPane.showMessageDialog(GameGUI.this.myFrame, result);
        }
    }

    private class listTeamHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            GameGUI.this.listing.setVisible(true);
            String xx = GameGUI.this.gp.getTeam();
            GameGUI.this.listing.setText(xx);
        }
    }

    private class ViewButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String result = gp.toString();
            JOptionPane.showMessageDialog(myFrame,result);
        }
    }

}
   
