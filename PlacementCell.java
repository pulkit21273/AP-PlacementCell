package AP1;
import java.util.*;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;




public class PlacementCell {
	private String PCname;
	private ArrayList<Company> companies = new ArrayList<Company>();
	private ArrayList<Student> registeredPCstudents = new ArrayList<Student>();
	private ArrayList<Student> students = new ArrayList<Student>();
	static Scanner sc = new Scanner(System.in);
	private ArrayList<Company> initial_companies = new ArrayList<Company>();
	private LocalDateTime cRegstart  ;
	private static LocalDateTime cRegend ;
	private ArrayList<Student> placedSt = new ArrayList<Student>() ;
	private ArrayList<Student> blocked = new ArrayList<Student>() ;
	
	
	public ArrayList<Student> getPlaced()
	{
		return placedSt;
	}
	
	public ArrayList<Student> getBlocked()
	{
		return blocked;
	}
	
	public void add_blocked(Student s)
	{
		this.blocked.add(s);
	}
	
	public void add_placedSt(Student s)
	{
		this.placedSt.add(s);
	}
	
	public static LocalDateTime getRegend()
	{
		return cRegend;
	}
	public LocalDateTime getRegstart()
	{
		return cRegstart;
	}
	public PlacementCell()
	{
		
	}
	
	public ArrayList<Company> getinitial_companies()
	{
		return initial_companies;
	}
	
	public void add_initialcomp(Company c)
	{
		this.initial_companies.add(c);
	}
	
	public ArrayList<Company> getCompanies()
	{
		return companies;
	}
	public ArrayList<Student> getregisteredPCstudents()
	{
		return registeredPCstudents;
	}
	
	public PlacementCell(String PCname)
	{
		this.PCname=PCname;
		
	}
	public void addStudenttoPClist(Student s)
	{
		this.registeredPCstudents.add(s);
	}
	public ArrayList<Student> get_students()
	{
		return students;
	}
	
	public void add_students(Student s)
	{
		this.students.add(s);
	}
	
	public static LocalDateTime datetime()
	{
		String s = sc.nextLine();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime date = LocalDateTime.parse(s , formatter);
		return date;
//		System.out.println(s);
	}
	
	public void printArrayList(ArrayList<Company> list)
	{
		for (int i=0;i<list.size();i++)
		{
			System.out.println((i+1) + ") " + list.get(i).getCname());
		}
	}
	
	public void add_company(Company c)
	{
		this.companies.add(c);
	}
	

	public void updateCGPA(Student s , float c)
	{
		s.setCGPA(c);
	}
	
	public void updateRole(Company c , String role)
	{
		c.setRole(role);
	}
	
	public static void openStudentsReg()
	{		
		LocalDateTime dt = LocalDateTime.now();
		boolean isbefore = cRegend.isBefore(dt);
		if (isbefore == true)
		{
			System.out.println("Instutite is open for Student registrations !");
			System.out.println("Set the Opening time for Student registrations : " );
			datetime();
			System.out.println("Set the Closing time for Student registrations " );
			datetime();
		}
		else {
			System.out.println("Company registrations have not ended yet !");
		}
		
	}
	
	public void openCompanyReg()
	{	
		System.out.println("Instutite is open for Company registrations !");
		System.out.println("Set the Opening time for company registrations : " );
		LocalDateTime a = datetime();
		this.cRegstart = a;
		
		System.out.println("Set the Closing time for company registrations : " );
		LocalDateTime b = datetime();
		this.cRegend = b;
	}
	
	public void regStudents()
	{
		System.out.println("Total number of students registered for placement drive : " + this.getregisteredPCstudents().size());
	}
	
	public void regCompanies()
	{
		System.out.println("Total number of companies registered for placement drive : " + this.getCompanies().size());
	}
	
	
	public void getCompanydetails(Company c)
	{	
		LocalDateTime time = c.companydate;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		String formatDateTime = time.format(format);
		
		System.out.println("Name of Company : " + c.getCname());
		System.out.println("Role offered : " + c.getRole());
		System.out.println("Salary offered : " + c.getSalary() + " LPA");
		System.out.println("CGPA required : " + c.getCgpareqd());
		System.out.println("Registration timings : " + formatDateTime);
	}
	
	public void getStudentDetails(Student s , long roll)
	{
		System.out.println("Student Name : " + s.getSName());
		System.out.println("Roll no : " + s.getSRoll());
		System.out.println("The student has applied in the following mentioned companies :- ");
		for (int i=0;i<s.getcompanieswhereStudentisReg().size();i++)
		{
			System.out.println("Companies where student registered :");
			System.out.println(s.getcompanieswhereStudentisReg().get(i).getCname());
		}
		System.out.println("------");
		
		System.out.println("The student has not applied in the following mentioned companies :- ");
		for (int i=0;i < s.getcompanieswhereStudentDIDNTreg().size();i++)
		{
				System.out.println("Companies where student didn't register :");
				System.out.println(s.getcompanieswhereStudentDIDNTreg().get(i).getCname());
		}	
	}
	
	
	
	
	public void avgpackage()
	{
		long sum = 0;
		for (int i=0;i<this.getCompanies().size();i++)
		{
			sum += this.getCompanies().get(i).getSalary();
		}
		System.out.println("Average Package :" + (sum/this.getCompanies().size()) + " LPA");
	}
	
	public void companyProcessResults(Company c)
	{
		c.select_randomStudents();
		System.out.println("Company has sent an offer to following students :");
		for (int i=0; i < c.getoffered_students().size() ; i++)
		{	
			System.out.println(c.getoffered_students().get(i).getSName()); 
		}
	}
	
	

}
	