import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class panel extends JPanel {
    Color[] masColors; // объявляем массив цветов, который будут в нашей  панели.
    int tCol = 0; // переменная отвечающая за текущий выбранный цвет
    public int mX, mY; //переменная для хранения координат мыши
    Boolean flag = false; // переменная, признак того, что полльзователь рисует

    // наш конструктор для класса Panel
    public panel() {
        //подключаем обработчики для мыши к нашей панели окна
        addMouseListener(new MyMouse1());
        addMouseMotionListener(new MyMouse2());
        // делаем окно активным
        setFocusable(true);

    }

    // метод, отрисовывающий графические компоненты на панеле
    @Override // слово @Override означает, что метод переопределен от какого-то интерфейса. Значит что в каком то интерфейсе этот метод уже прописан и мы просто его тут вызываем
    public void paintComponent(Graphics g) {
        Color[] masColor = new Color[7]; //"рождаем" массив состоящий из 7 элементов. ВКЛЮЧАЯ "0"!!!!!
        masColor[0] = Color.BLACK; // задаем цвет каждому элементу массива
        masColor[1] = Color.GREEN;// задаем цвет каждому элементу массива
        masColor[2] = Color.BLUE;// задаем цвет каждому элементу массива
        masColor[3] = Color.RED;// задаем цвет каждому элементу массива
        masColor[4] = Color.YELLOW;// задаем цвет каждому элементу массива
        masColor[5] = Color.WHITE;// задаем цвет каждому элементу массива
        masColor[6] = Color.ORANGE;// задаем цвет каждому элементу массива

        for (int i = 0; i < 7; i++) {// рисуем циклом 7 прямоугольников в врехней части для выбора цвета
            // устанавливаем цвет для рисования
            g.setColor(masColor[i]);
            // рисуем закрашенный прямоугольник
            g.fillRect(i * 100, 0, 100, 50);
            //  Если признак присования(пользовтель рисует) TRUE(ИСТИНА) - рисуем маленький квадрат выбранным цветом в точке, где находится курсор мыши
            if (flag = true) {
                // устанавливаем цвет рисования
                g.setColor(masColor[tCol]);
                // рисуем закрашенный маленький квадрат
                g.fillRect(mX, mY, 3, 3);
            }
        }

    }

    // класс MyMouse1 реализует интерфейс MouseListener, который позволяет обрабатывать события мыши. Слово "implements" означает что реализуется интерфейс MouseListener.
    class MyMouse1 implements MouseListener{

        //метод, срабатывающий при щелчке по кнопке мышки
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        //метод, при нажатии на кнопку мыши
        @Override
        public void mousePressed(MouseEvent e) {

            int tX = e.getX(); //получаем координаты мыши
            int tY = e.getY(); //получаем координаты мыши
            int col = e.getClickCount(); //получаем количество нажатой клавиши
            int btn = e.getButton(); //получаем номер нажатой клавиши - 1,2 или 3
            if((tX>0) && (tX<700) && (tY>0) && (tY<500)){ //прверяем, что сейчас курсор находитс в области выбора цвета
                if(col==1)
                {
                    if(btn==1)
                    {
                        tCol = tX/100;
                    }
                }
            }
        }

        //метод, срабатывающий если пользователь отпускает клавишу мыши
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        //метод, срабатывающий при появлении курсора на панеле окна
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        //метод, срабатывающий если курсор выходит за пределы окна
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    // класс MyMouse2 реализует интерфейс MouseMotionListener, который позволяет обрабатывать события мыши. Слово "implements" означает что реализуется интерфейс MouseMotionListener.
    class MyMouse2  implements MouseMotionListener {

        // метод, который анализирует перемещение мыши при нажатой левой кнопке
        @Override
        public void mouseDragged(MouseEvent e) {
            int tX = e.getX(); //получаем координаты мыши
            int tY = e.getY(); //получаем координаты мыши
            //если курсор в той части, где можно рисовать
            if(tY>50){

                mX = tX; // запоминаем координаты мыши в переменных
                mY = tY; // запоминаем координаты мыши в переменных
                flag = true; // признак того, что пользователь рисует
                repaint();

            }
        }

        // метод, который анализирует сам факт перемещения курсора мыши по экрану
        @Override
        public void mouseMoved(MouseEvent e) {
            int tX = e.getX(); // задаем координаты по оси Х
            int tY = e.getY();// задаем координаты по оси У
            if((tX>0) && (tX<700) && (tY>0) && (tY<500)){  //прверяем, что сейчас курсор находитс в области выбора цвета
                setCursor(new Cursor(Cursor.HAND_CURSOR)); //Установки курсора в виде пальца
            }else{
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //Установки курсора в виде стрелочки
            }
            //вывод в консольное окно текущих координат курсор амыши Х, У
            System.out.println(e.getX()+""+e.getY());
        }
    }


}
