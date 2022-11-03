package AP1;

import java.util.*;



public class Student {
	
//	static Scanner sc = new Scanner(System.in);
	private ArrayList<Company> companieswhereStudentisReg = new ArrayList<Company>();
	private ArrayList<Company> companieswhereStudentDIDNTreg = new ArrayList<Company>();
	private ArrayList<Company> companies_offered = new ArrayList<Company>();
	
	private String name;
	private long roll;
	private float CGPA;
	private String branch;
	private static int numStudents;
	private boolean appliedForCompany = false;
	private boolean isplaced = false;
	private boolean isblocked = false;
	private boolean eligible = false;
	private long currentoffer = 0;
	private PlacementCell placementcell;
	private boolean accepted = false;
	private boolean rejected =false;
	private boolean has_rejected = false;
	
	
	public boolean get_hasrejected()
	{
		return has_rejected;
	}
	
	public boolean get_isplaced()
	{
		return isplaced;
	}
	
	public ArrayList<Company> getcompanies_offered()
	{
		return companies_offered;
	}
	
	public void add_companiesoffered(Company c)
	{
		this.companies_offered.add(c);
	}
	
	public ArrayList<Company> getcompanieswhereStudentDIDNTreg()
	{
		return companieswhereStudentDIDNTreg;
	}
	
	public boolean getApplied()
	{
		return appliedForCompany;
	}
	
	public boolean getEligible()
	{
		return eligible;
	}
	
	public void setSname(String name)
	{
		this.name = name;
	}
	public String getSName()
	{
		return name;
	}
	
	public void setSRoll(int roll)
	{
		this.roll = roll;
	}
	
	public long getSRoll()
	{
		return roll;
	}
	
	public void setSBranch(String branch)
	{
		this.branch = branch;
	}
	
	public String getSBranch()
	{
		return branch;
	}
	
	public void setCGPA(float CGPA)
	{
		this.CGPA = CGPA;
	}
	
	public float getCGPA()
	{
		return CGPA;
	}
	
	public static int getNumStudents()
	{
		return numStudents;
	}
	
	
	public ArrayList <Company> getcompanieswhereStudentisReg()
	{
		return companieswhereStudentisReg;
	}
	
	public void setcurrentOffer(long currentoffer) {
		this.currentoffer = currentoffer;
	}
	
	public long getcurrentOffer()
	{
		return currentoffer;
	}
	
	public void isEligible(Company c)
	{
		if (this.isplaced == false && this.isblocked == false && this.getCGPA()>c.getCgpareqd() && (this.currentoffer)*3 <= c.getSalary())
		{
			eligible = true;
		}
		if (this.isplaced = true && (this.currentoffer)*3 <= c.getSalary())
		{
			eligible = true;
		}
	}
	
//	public void blocked()
//	{
//		if (this.isplaced == false)
//		{
//			for (int i=0;i<this.getcompanieswhereStudentisReg().size();i++)
//			{
//				this.isEligible(this.getcompanieswhereStudentisReg().get(i));
//				if (this.eligible == true)
//				{
//					rejectOffer(this.getcompanieswhereStudentisReg().get(i));
//				}
//			}
//		}
//	}
	
	
	
	public void getAllCompanies()
	{
		if (this.isblocked == true)
		{
			System.out.println("Unavailable");
			return;
		}
		for (int i=0;i<placementcell.getCompanies().size();i++)
		{
			this.isEligible(placementcell.getCompanies().get(i));
			if (this.eligible == true)
			{
				placementcell.getCompanies().get(i).print();
			}
		}
	}
	
	
//	public Student(String name , long roll)
//	{
//		this.name = name;
//		this.roll = roll;
//	}
	
	
	public Student(String name , long roll , float CGPA , String branch , PlacementCell p) 
	{
		this.name = name;
		this.roll = roll;
		this.CGPA = CGPA;
		this.branch = branch;
		this.placementcell=p;
		numStudents++;
	}
	
	public void registerForCompany(Company c)
	{
		if (this.getCGPA() >= c.getCgpareqd())
		{
			this.appliedForCompany = true;
			this.companieswhereStudentisReg.add(c);
			c.add_selectedstudent(this);
			System.out.println("Successfully Registered for "+ "'" + c.getRole() + "'" + " role at " + c.getCname());
		}
		else
		{
			this.companieswhereStudentDIDNTreg.add(c);
			System.out.println("Sorry, you are not eligible !");
		}
	}
	
	
	public void getCurrentStatus()
	{
		if (this.has_rejected == true && this.companies_offered.size() == 0)
		{
			this.isblocked = true;
			placementcell.add_blocked(this);
			System.out.println(this.getSName() + " is blocked !");
			
		}
		else if (this.companies_offered.size() != 0)
		{
			System.out.println("Offered !");
			for (int i=0 ; i < this.companies_offered.size() ; i++)
			{
				System.out.println("Name : " + this.companies_offered.get(i).getCname());
				System.out.println("CGPA required : " + this.companies_offered.get(i).getCgpareqd());
				System.out.println("Role : " +this.companies_offered.get(i).getRole());
				System.out.println("Package : " + this.companies_offered.get(i).getSalary() + " LPA");
			}
		}
		
		else if (this.companies_offered.size() == 0)
		{
			System.out.println("Unoffered !");
		}
	}
	
	public boolean get_isblocked()
	{
		return isblocked;
	}
	public void companieswhereStudentDIDNTregFUNC(Company c)
	{
		if (this.companieswhereStudentisReg.contains(c))
		{
			return;
		}
		else
		{
			this.companieswhereStudentDIDNTreg.add(c);
		}
	}
	
	public void updatecgpabyPC(float c)
	{
		placementcell.updateCGPA(this,c);
	}
	
	public void acceptOffer(Company c)
	{
		this.accepted=true;
		this.isplaced=true;
		this.setcurrentOffer(c.getSalary());
		placementcell.add_placedSt(this);
		System.out.println(this.getSName() + " has got a package of : " + c.getSalary() + " LPA");
	}
	
	public void rejectOffer(Company c)
	{
		this.has_rejected=true;
		this.rejected=true;
	}
		
}
