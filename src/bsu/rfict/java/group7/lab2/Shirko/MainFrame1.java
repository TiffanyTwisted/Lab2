package bsu.rfict.java.group7.lab2.Shirko;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame1  extends JFrame {
    // Размеры окна приложения в виде констант
    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;
private static Double summ = 0.0;
    // Текстовые поля для считывания значений переменных,
    // как компоненты, совместно используемые в различных методах
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;

    // Текстовое поле для отображения результата,
    // как компонент, совместно используемый в различных методах
    private JTextField textFieldResult;
    private JTextField textFieldResultSumm;
    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();
    // Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    private int formulaId = 1;

    // Формула №1 для рассчѐта
    public Double calculate1(Double x, Double y, Double z) { return (Math.sin(y)+y*y+Math.exp(Math.cos(y)))*(Math.pow(Math.log(z)+Math.sin(x*x), 0.25));
    }
    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y, Double z) { return ((Math.tan(x*x)+Math.sqrt(y))/(z*Math.log(x+y)));
    }
    // Вспомогательный метод для добавления кнопок на панель
    private void addRadioButton(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame1.this.formulaId = formulaId;
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }
    // Конструктор класса
    public MainFrame1() {
        super("Вычисление формулы");
        this.setSize(400, 200);
        Toolkit kit = Toolkit.getDefaultToolkit();
        // Отцентрировать окно приложения на экране
        this.setLocation((kit.getScreenSize().width - 400) / 2, (kit.getScreenSize().height - 320) / 2);

        this.hboxFormulaType.add(Box.createHorizontalGlue());
        this.addRadioButton("Формула 1", 1);
        this.addRadioButton("Формула 2", 2);
        this.radioButtons.setSelected(((AbstractButton) this.radioButtons.getElements().nextElement()).getModel(), true);
        this.hboxFormulaType.add(Box.createHorizontalGlue());
        this.hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        // Создать область с полями ввода для X и Y  и Z
        JLabel labelForX = new JLabel("X:");
        this.textFieldX = new JTextField("0", 10);
        this.textFieldX.setMaximumSize(this.textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        this.textFieldY = new JTextField("0", 10);
        this.textFieldY.setMaximumSize(this.textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        this.textFieldZ = new JTextField("0", 10);
        this.textFieldZ.setMaximumSize(this.textFieldX.getPreferredSize());
        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(this.textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(this.textFieldY);
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(this.textFieldZ);

        hboxVariables.add(Box.createHorizontalGlue());
        JLabel labelForResult = new JLabel("Результат:");
        this.textFieldResult = new JTextField("0", 15);
        this.textFieldResult.setMaximumSize(this.textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(this.textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Double x = Double.parseDouble(bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.textFieldX.getText());
                    Double z = Double.parseDouble(bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.textFieldX.getText());
                    Double y = Double.parseDouble(bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.textFieldY.getText());
                    Double result;
                    if (bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.formulaId == 1) {
                        result = bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.calculate1(x, y, z);
                    } else {
                        result = bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.calculate2(x, y, z);
                    }

                    bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.textFieldResult.setText(result.toString());
                } catch (NumberFormatException var5) {
                    JOptionPane.showMessageDialog(bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this, "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа", 2);
                }

            }
        });
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.textFieldX.setText("0");
                bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.textFieldY.setText("0");
                bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.textFieldZ.setText("0");
                bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.textFieldResult.setText("0");
            }
        });
        JButton buttonM = new JButton("M+");
        buttonM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                summ += Double.parseDouble(bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.textFieldResult.getText());
                System.out.println(summ);
                bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.textFieldResultSumm.setText(summ.toString());
            }
        });
        JButton buttonMC = new JButton("MC");
        buttonMC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                summ = 0.0;
                bsu.rfict.java.group7.lab2.Shirko.MainFrame1.this.textFieldResultSumm.setText(summ.toString());
            }
        });

        JLabel labelForResultMC = new JLabel("Результат общий:");
        this.textFieldResultSumm = new JTextField("0", 15);
        this.textFieldResultSumm.setMaximumSize(this.textFieldResultSumm.getPreferredSize());
        Box hboxResultMC = Box.createHorizontalBox();
        hboxResultMC.add(Box.createHorizontalGlue());
        hboxResultMC.add(labelForResultMC);
        hboxResultMC.add(Box.createHorizontalStrut(10));
        hboxResultMC.add(this.textFieldResultSumm);
        hboxResultMC.add(Box.createHorizontalGlue());
        hboxResultMC.setBorder(BorderFactory.createLineBorder(Color.BLUE));


        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonMC);
        hboxButtons.add(buttonM);
        hboxButtons.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(this.hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons);
        contentBox.add(hboxResultMC);
        contentBox.add(Box.createVerticalGlue());
        this.getContentPane().add(contentBox, "Center");



    }


    public static void main(String[] args) {
        MainFrame1 frame = new MainFrame1();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
