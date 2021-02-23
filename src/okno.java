import javax.swing.*; //библиотеки для работы с окном
import java.awt.*;//библиотеки для работы с окном
//Класс okno отвечает за наше окно редактора.
class okno extends JFrame {
    public okno() throws HeadlessException {
        setBounds(0, 0, 800, 600); //устанавливаем размеры окна
        setTitle("Управление приложением с помощью мыши"); //устанавливаем название нашего окна редактора
        panel pan = new panel(); //создаем новую панель
        Container con = getContentPane(); //получаем содержимое панели
        con.add(pan);//добавляем нашу панель
        setVisible(true); //делаем ее видимой
    }

}
