package com.streamliners.sendingobjects.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represents student class which implement {@link Parcelable} to make a Student class object parcelable to send it from one activity to another
 */
public class Student implements Parcelable {
    private String name;
    private String mobileNumber;
    private String rollNumber;
    private String gender;

    /**
     * Constructor to construct student class
     */
    public Student() {
    }

    /**
     * Constructor to construct student class
     * @param name          name of the student
     * @param mobileNumber  mobile number of the student
     * @param rollNumber    roll number of the student
     * @param gender        gender of the student
     */
    public Student(String name, String mobileNumber, String rollNumber, String gender) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.rollNumber = rollNumber;
        this.gender = gender;
    }

    /**
     * This Constructor is used to make the object parcelable
     * @param in a {@link Parcel} class object
     */
    public Student(Parcel in){
        String[] data = new String[4];

        in.readStringArray(data);

        // the order needs to be the same as in writeToParcel() method
        this.name = data[0];
        this.mobileNumber = data[1];
        this.rollNumber = data[2];
        this.gender = data[3];
    }

    // I don't know how but these plays a crucial role to create a parcelable object

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.name,
                this.mobileNumber,
                this.rollNumber,
                this.gender});
    }

    // The Parcel constant
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    // all the getters

    /**
     * @return name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * @return mobile number of the student
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @return roll number of the student
     */
    public String getRollNumber() {
        return rollNumber;
    }

    /**
     * @return gender of the student
     */
    public String getGender() {
        return gender;
    }
}
