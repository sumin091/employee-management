package controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ReadDocsEvent extends WindowAdapter implements ActionListener {

	private ReadDocsEvent rde;
	
	
	public ReadDocsEvent(ReadDocsEvent rde) {
		rde= this.rde;
	}

	public void readDoc(int Empno) {
		
	}
	
	public void updateDoc() {
		
	}
	
	public void deleteDoc() {
		
	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        //rde.dispose();
    }
	
	
	
}


