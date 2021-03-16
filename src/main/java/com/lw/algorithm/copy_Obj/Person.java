package com.lw.algorithm.copy_Obj;

import java.io.*;

public class Person implements Cloneable ,Serializable {

    private String name;
    private int age;
    private Computer computer;

    public Person(String name, int age, Computer computer) {
        this.name = name;
        this.age = age;
        this.computer = computer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = (Person)super.clone();
        person.computer=(Computer)this.computer.clone();
        return person;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Computer mac = new Computer("Mac");

        Person p1=new Person("溜溜溜",18,mac);
        System.out.println(p1);

        // 1.重写clone方法实现克隆：
        Person clone = (Person)p1.clone();
        System.out.println(clone);
        Person clone2 = (Person)p1.clone();
        System.out.println(clone2);

        mac.setComputerName("lenovo");
        System.out.println(p1.getComputer().getComputerName());
        System.out.println(clone.getComputer().getComputerName());
        System.out.println(clone2.getComputer().getComputerName());

        // 2.序列化共和反序列化实现克隆：
//        Person clone = p1.deepClone();
//        mac.setComputerName("lenovo");
//        System.out.println(clone.getComputer().getComputerName());



    }

    public Person deepClone(){
        ByteArrayOutputStream bos = null;
        ByteArrayInputStream bis = null;

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            bos= new ByteArrayOutputStream();
            oos= new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois=new ObjectInputStream(bis);

            return (Person)ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                ois.close();
                bis.close();
                oos.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }



}
