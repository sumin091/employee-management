package kr.co.sist.controller.event;

import kr.co.sist.dao.CreateEmployeeInformationDAO;
import kr.co.sist.view.admin.CheckEmployeeInformation;
import kr.co.sist.view.admin.CreateEmployeeInformation;
import kr.co.sist.vo.EmpInfoVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class CreateEmployeeInformationEvent extends WindowAdapter implements ActionListener {
    private CreateEmployeeInformation ceiv;

    public CreateEmployeeInformationEvent() {
    }// CreateEmployeeInformationEvent

    public CreateEmployeeInformationEvent(CreateEmployeeInformation ceiv) {
        this.ceiv = ceiv;
    }// CreateEmployeeInformationEvent

    @Override
    public void windowClosing(WindowEvent e) {
        ceiv.dispose();
    }// windowClosing

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ceiv.getJbtnAdd()) {
            addEmp();
            ceiv.dispose();
            new CheckEmployeeInformation();
        } // end if
        if (ae.getSource() == ceiv.getJbtnCancel()) {
            ceiv.dispose();
            new CheckEmployeeInformation();
        } // end if
    }// actionPerformed

    /**
     * 입력받은 사원의 정보를 정리하고, DAO와 연결하는 method
     */
    public void addEmp() {
        String name = ceiv.getTfName().getText().trim();
        String job = ceiv.getTfJob().getText().trim();
        String position = ceiv.getTfPosition().getText().trim();
        String tel = ceiv.getTfTel().getText().trim();
        String dept = ceiv.getTfDep().getText().trim();
        if(name.isEmpty()||job.isEmpty()||position.isEmpty()||tel.isEmpty()||dept.isEmpty()) {
        	JOptionPane.showMessageDialog(ceiv, "모든 정보가 입력되어야합니다.");
        	return;
        }
       int askagain = JOptionPane.showConfirmDialog(null, "정말로 추가 하시겠습니까?" ,"확인",JOptionPane.YES_NO_OPTION);
        if(askagain ==JOptionPane.YES_OPTION) {
        	
        try {
            CreateEmployeeInformationDAO ceDAO = CreateEmployeeInformationDAO.getInstance();
            int empno = ceDAO.selectMaxEmpnum();
            EmpInfoVO eVO = new EmpInfoVO(0, name, job, position, dept, null, tel, null);
            ceDAO.insertEmpInfo(empno,eVO);
            ceDAO.insertAccountEmp(empno);
            ceDAO.insertUserAuthEmp(empno);
            ceDAO.insertDefaultVacaion(empno);
            JOptionPane.showMessageDialog(ceiv, "사원 번호 " + empno + " 번, " + name + "님이 등록되었습니다.");
         
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }
        
    }
}// class
