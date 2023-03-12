package PACKAGE1;
import java.util.*;

public class tuition {

	String studentType, courseName;
	int totalTuition, tuition = 0, miscellaneous = 0;
	String discount = " ";
	
	public tuition(Object object, Object object2) {		
		this.studentType = (String) object;
		this.courseName = (String) object2;
		
		course();
		tuitionFee();
		}
	 	
	public void course() {
		/* 
		 * TOURISM – Tuition: 10,000; Miscellaneous: 22,500
		 * COMPUTER SCIENCE – Tuition 20,000; Miscellaneous: 11,000
		 * ENGINEERING – Tuition: 30,000; Miscellaneous: 25,000
		 * NURSING – Tuition: 15,000; Miscellaneous: 15,000
		 * ARCHITECTURE – Tuition: 25,000; Miscellaneous: 23,000
		 */
		
		if(courseName.equalsIgnoreCase("tourism")) {
			tuition = 10000; miscellaneous = 22500;
		}else if(courseName.equalsIgnoreCase("computer science")) {
			tuition = 20000; miscellaneous = 11000;
		}else if(courseName.equalsIgnoreCase("engineering")) {
			tuition = 30000; miscellaneous = 25000;
		}else if(courseName.equalsIgnoreCase("nursing")) {
			tuition = 15000; miscellaneous = 15000;
		}else if(courseName.equalsIgnoreCase("architecture")) {
			tuition = 25000; miscellaneous = 23000;
		}
	}
	
	public void tuitionFee() {
		/*
		 * Discounted: Gold - 50% discount for both tuition fee and miscellaneous.
		 * Discounted: Blue - 30% discount for both tuition fee and miscellaneous.
		 * Discounted: White - 10% discount for both tuition fee and miscellaneous.
		 * Walk-in - No discount
		 * Continuing - 10% discount for tuition fee only.
		 */
		
		if(studentType.equalsIgnoreCase("Discounted (Gold)")) {
			discount = "(50% discount for total tuition fee)";
			totalTuition = (int) ((tuition + miscellaneous) * 0.5);
		}else if(studentType.equalsIgnoreCase("Discounted (Blue)")) {
			discount = "(30% discount for total tuition fee)";
			totalTuition = (int) ((tuition + miscellaneous) * 0.7);
		}else if(studentType.equalsIgnoreCase("Discounted (White)")) {
			discount = "(10% discount for total tuition fee)";
			totalTuition = (int) ((tuition + miscellaneous) * 0.9);
		}else if(studentType.equalsIgnoreCase("Walk-in")) {
			totalTuition = (int) (tuition + miscellaneous);
		}else if(studentType.equalsIgnoreCase("Continuing")) {
			discount = "(10% discount for tuition fee only)";
			totalTuition = (int) ((0.9 * tuition) + miscellaneous);
		}
	}
}
