package AP1;
import java.util.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Company 
{
	private String Cname;
	private String role;
	private long salary;
	private float cgpareqd;
	private static int numCompanies;
	private PlacementCell placementcell;
	private boolean selectedStudent = false;
	private ArrayList<Student> selected_students = new ArrayList<Student>();
	private ArrayList<Student> offered_students = new ArrayList<Student>();
	
	

	
	
	public ArrayList<Student> getselected_students()
	{
		return selected_students;
	}
	
	public ArrayList<Student> getoffered_students()
	{
		return offered_students;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}

	
//	public void add_selected_student(Student s)
//	{
//		s.isEligible(this);
//		if (s.getEligible() == true && s.getApplied() == true)
//		{
//			this.selected_students.add(s);
//		}
//	}
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public void select_randomStudents()
	{
		for (int i=0 ; i < getRandomNumber(1 , this.selected_students.size());i++)
		{
			this.offered_students.add(this.selected_students.get(i));
			this.selected_students.get(i).add_companiesoffered(this);
		}
	}
	public void setCname(String Cname)
	{
		this.Cname = Cname;
	}
	
	public String getCname()
	{
		return Cname;
	}
	
	public String getRole()
	{
		return role;
	}
	
	public void setSalary(long salary)
	{
		this.salary = salary;
	}
	
	public long getSalary()
	{
		return salary;
	}
	
	public void setCgpareqd(float cgpareqd)
	{
		this.cgpareqd = cgpareqd;
	}
	
	public float getCgpareqd()
	{
		return cgpareqd;
	}
	
	public static int getNumCompanies()
	{
		return numCompanies;
	}
	
	public void print()
	{
		System.out.println(this.Cname);
		System.out.println(this.role);
		System.out.println(this.salary);
		System.out.println(this.cgpareqd);
	}
	
	public Company(String Cname , String role , long salary , float cgpareqd,PlacementCell p)
	{
		this.Cname = Cname;
		this.role = role;
		this.salary = salary;
		this.cgpareqd = cgpareqd;
		this.placementcell=p;
		numCompanies++;
	}
	public LocalDateTime companydate;
	public void regToPlacementdrive()
	{
		LocalDateTime dt = LocalDateTime.now();
		companydate = dt;
		boolean isBefore = dt.isBefore(placementcell.getRegend());
		boolean isAfter = dt.isBefore(placementcell.getRegstart());
		if (isAfter == true)
		{
			System.out.println("Company registrations have not started yet !");
		}
		else if (isBefore == true)
		{
			placementcell.add_company(this);
			System.out.println("Registered successfully !");
		}
		else if (isBefore == false)
		{
			System.out.println("Sorry, Deadline is over for Company Registrations !");
		}
		

	}
	
	public void add_selectedstudent(Student s)
	{
		this.selected_students.add(s);
	}
	
	public void selectedofferedStudents()
	{
		for (int i=0;i<this.selected_students.size();i++)
		{
			printStudent(this.selected_students.get(i));
		}
	}
	
	public void printStudent(Student s)
	{
		System.out.println(s.getSName());
		System.out.println(s.getSRoll());
	    System.out.println(s.getCGPA());
	    System.out.println(s.getSBranch());
	}
	
	public void updatecgpareqd(float cgpa)
	{
		this.setCgpareqd(cgpa);
	}
	
	public void updateSalary(long salary)
	{
		this.setSalary(salary);
	}
	
}
