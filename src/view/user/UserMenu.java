package view.user;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UserMenu extends JFrame {
    private JButton login;
    private JButton docsList;
    private JButton vacation;
    private JButton information;
    private JButton workLog;
    private JCalendar workCalendar;
    private DefaultListModel<String> workStatusModel;
    private JList<String> workStatusList;
    private JScrollPane workStatusPad;

    public UserMenu(){
        setTitle("사원 메뉴");
        setLayout(null);

        createWorkCalendar();
        createGoToButton();
        createWorkStatusList();

        setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createWorkCalendar(){
        workCalendar = new JCalendar();

        workCalendar.setBorder(new TitledBorder("근무일정"));
        workCalendar.setBounds(20,150,290,350);

        add(workCalendar);
    }

    public void createGoToButton(){
        login = new JButton("로그인으로");
        docsList = new JButton("문서 리스트");
        vacation = new JButton("휴가 신청");
        information = new JButton("정보 변경");
        workLog = new JButton("업무 일지");

        login.setBounds(500,10,100,40);
        docsList.setBounds(50,70,100,40);
        vacation.setBounds(200,70,100,40);
        information.setBounds(350,70,100,40);
        workLog.setBounds(500,70,100,40);

        add(login);
        add(docsList);
        add(vacation);
        add(information);
        add(workLog);
    }

    public void createWorkStatusList(){
        workStatusModel = new DefaultListModel<>();
        workStatusList = new JList<>(workStatusModel);
        workStatusPad = new JScrollPane(workStatusList);

        workStatusPad.setBorder(new TitledBorder("이달의 근무"));
        workStatusPad.setBounds(330,150,290,350);

        add(workStatusPad);
    }

    public static void main(String[] args) {
        new UserMenu();
    }
}
