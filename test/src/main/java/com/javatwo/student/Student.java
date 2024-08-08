package com.javatwo.student;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.javatwo.studentengagement.Course;
import com.javatwo.studentengagement.CourseEngagement;

public class Student {
    private static long lastStudentId = 1;

    private final static Random random = new Random();

    private final long studentId;

    private final String countryCode;

    private final int yearEnrolled;

    public int getAgeEnrolled() {
        return ageEnrolled;
    }

    public boolean isProgrammingExperience() {
        return programmingExperience;
    }

    private final int ageEnrolled;
    
    private final String gender;


    private final boolean programmingExperience;

    private final Map<String, CourseEngagement> engagementMap = new HashMap<>();

    public Student(String countryCode, int yearEnrolled,int ageEnrolled,  String gender, boolean programmingExperience, Course... courses) {
        studentId = lastStudentId++;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled = ageEnrolled;
        this.gender = gender;
        this.programmingExperience = programmingExperience;

        for (Course course : courses) {
            addCourse(course, LocalDate.of(yearEnrolled, 1,1));
        }
    }

    public void addCourse(Course newCourse){
        addCourse(newCourse, LocalDate.now());
    }

    private void addCourse(Course newCourse, LocalDate enrollDate) {

        CourseEngagement myCourse =  new CourseEngagement(newCourse, enrollDate, "Enrollment");
        engagementMap.put(newCourse.courseCode(), myCourse);

    }

    public static Random getRandom() {
        return random;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    public String getGender() {
        return gender;
    }

    public boolean hasProgrammingExperience() {
        return programmingExperience;
    }

    public Map<String, CourseEngagement> getEngagementMap() {
        return Map.copyOf( engagementMap);
    }

    public int getYearsSinceEnrollment(){
        return LocalDate.now().getYear() - yearEnrolled;
    }

    public int getAge(){
        return ageEnrolled + getYearsSinceEnrollment();
    }

    public int getMonthsSinceActive(String courseCode){
        CourseEngagement info = engagementMap.get(courseCode);

        return info == null ? 0 : info.getMonthsSinceActive();
    }

    public int getMonthsSinceActive(){
        int inactiveMonths = (LocalDate.now().getYear() - 2014) * 12;

        for (String key : engagementMap.keySet()) {
            inactiveMonths = Math.min(inactiveMonths, getMonthsSinceActive(key));
        }

        return inactiveMonths;
    }

    public double getPercentComplete(String coursecode){
        var info = engagementMap.get(coursecode);

        return (info == null) ? 0 : info.getPercentComplete();
    }

    public void watchLecture (String courseCode, int lectureNumber, int month, int year){
        var activity  = engagementMap.get(courseCode);

        if(activity != null){
            activity.watchLecture(lectureNumber, LocalDate.of(year, month, 1));


        }
    }

    public static String getRandomVal(String... data){
        return data[random.nextInt(data.length)];
    }

    public static Student getRandomStudent(Course... courses){
        int maxYear = LocalDate.now().getYear() + 1;

        Student student = new Student(getRandomVal("AU","KE", "UG", "US", "TZ", "UK", "EN"), random.nextInt(2015, maxYear), random.nextInt(18, 90) , getRandomVal("M", "F", "U"), random.nextBoolean(), courses);

        for (Course c : courses) {
            int lecture = random.nextInt(30, c.lectureCount());
            int year = random.nextInt(student.getYearEnrolled(), maxYear);
            int month = random.nextInt(1,13);

            if(year == (maxYear-1)){
                if(month > LocalDate.now().getMonthValue()){
                    month = LocalDate.now().getMonthValue();
                }
            }

            student.watchLecture(c.courseCode(), lecture, month, year);
        }

        return student;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", countryCode=" + countryCode + ", yearEnrolled=" + yearEnrolled
                + ", ageEnrolled=" + ageEnrolled + ", gender=" + gender + ", programmingExperience="
                + programmingExperience + ", engagementMap=" + engagementMap + "]";
    }

  

    
     
}
