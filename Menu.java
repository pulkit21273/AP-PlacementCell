package AP1;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void enter()
	{
		System.out.println("Welcome to FutureBuilder :");
		System.out.println("1. Enter the application");
		System.out.println("2. Exit the application");
		
	}
	
	public static void modes()
	{
		System.out.println("Choose The mode you want to Enter in:-\n"
		+ "1) Enter as Student Mode\n"
		+ "2) Enter as Company Mode\n"
		+ "3) Enter as Placement Cell Mode\n"
		+ "4) Return To Main Application");
	}
	
	public static void studentmode()
	{
		System.out.println("Choose the Student Query to perform-\n"
		+ "1) Enter as a Student(Give Student Name, and Roll No.)\n"
		+ "2) Add students\n"
		+ "3) Back");
		
	}
	
	public static void placementcellmode()
	{
		System.out.println("Welcome IIITD Placement Cell\n"
				+ "1) Open Student Registrations\n"
				+ "2) Open Company Registrations\n"
				+ "3) Get Number of Student Registrations\n"
				+ "4) Get Number of Company Registrations\n"
				+ "5) Get Number of Offered/Unoffered/Blocked Students\n"
				+ "6) Get Student Details\n"
				+ "7) Get Company Details\n"
				+ "8) Get Average Package\n"
				+ "9) Get Company Process Results\n"
				+ "10) Back");
	}
	
	public static void companymode()
	{
		System.out.println("1) Add Company and Details\n"
				+ "2) Choose Company\n"
				+ "3) Get Available Companies\n"
				+ "4) Back");
	}
	
	
	public static void main(String[] args) 
	{
		Scanner x = new Scanner(System.in);
		String S = x.nextLine();
		
		if (S.equals("Enter FutureBuilder"))
		{
			while (true)
			{
				enter();
				int a = x.nextInt();
				PlacementCell pc = new PlacementCell();
				
				if (a == 1)
				{
					while (true)
					{
						modes();
						int b = x.nextInt();
						if (b == 1)
						{
							while (true)
							{
								studentmode();
								int b1 = x.nextInt();
								if (b1 == 1)
								{
									while (true)
									{
										
									System.out.println("Enter name :");
									x.nextLine();
									String name = x.nextLine();
									System.out.println("Enter roll no. :");
									long roll = x.nextLong();
									System.out.println(name);
									System.out.println(roll);
									ArrayList <Student> temp = pc.get_students();
									while (true)
									{
									for (int i=0;i<temp.size();i++)
									{	
											if (roll == temp.get(i).getSRoll())
											{
	//											System.out.println(temp.get(i).getSRoll());
												
	
															System.out.println("Welcome, "+ name +" !");
															System.out.println("1) Register For Placement Drive\n"
																	+ "2) Register For Company\n"
																	+ "3) Get All available companies\n"
																	+ "4) Get Current Status\n"
																	+ "5) Update CGPA\n"
																	+ "6) Accept offer\n"
																	+ "7) Reject offer\n"
																	+ "8) Back");
															int b11 = x.nextInt();
															if (b11 == 1)
															{
																
																pc.addStudenttoPClist(temp.get(i));
																System.out.println("Registered in Placement Cell successfully !");
															}
															else if (b11 == 2)
															{
																System.out.println("Enter name of Company :");
																String cname = x.next();
																ArrayList<Company> temp2 = pc.getCompanies();
																for (int j=0 ; j < temp2.size(); j++)
																{
																	
																	if (cname.equals(temp2.get(j).getCname()))
																	{
																		temp.get(i).registerForCompany(temp2.get(j));
																	}
																}															
															}
															
															else if (b11 == 3)
															{
																temp.get(i).getAllCompanies();
															}
															else if (b11 == 4)
															{
																temp.get(i).getCurrentStatus();
															}
															else if (b11 == 5)
															{
																System.out.println("Enter New CGPA :");
																float newCG = x.nextFloat();
																pc.updateCGPA(temp.get(i) , newCG);				
															}
															else if (b11 == 6)
															{
																System.out.println("Please type YES to access offer accept feature :");
																String Y = x.next();
																
																if (Y.equals("YES"))
																{
																	
																	temp.get(i).acceptOffer(temp.get(i).getcompanies_offered().get((temp.get(i).getcompanies_offered().size()-1)));
																}
															}
															else if (b11 == 7)
															{
																System.out.println("Please type YES to access offer reject feature :");
																String N = x.next();
																
																if (N.equals("YES"))
																{
																	temp.get(i).rejectOffer(temp.get(i).getcompanies_offered().remove((temp.get(i).getcompanies_offered().size()-1)));
																}
															}		
											}
										}
									break;
										}
									break;
									}
								}
								
								else if (b1 == 2)
								{
									System.out.println("Enter number of students :");
									int n = x.nextInt();
//									x.nextLine();
									for (int i=0; i<n;i++)
									{
										
										System.out.println("Enter Student "+(i+1));
										System.out.println("Enter name :");
										String name = x.next();
//										x.nextLine();
										System.out.println("Enter Roll no. :");
										long roll = x.nextLong();
										System.out.println("Enter CGPA :");
										float cgpa = x.nextFloat();
										System.out.println("Enter Branch :");
										String branch = x.next();
										System.out.println(name);
										Student s = new Student(name,roll,cgpa,branch,pc);
										pc.add_students(s);
										System.out.println("-------");
									}
								}
								
								else if (b1 == 3)
								{
									break;
								}
							}
						}
						
						else if (b == 2)
						{
							while (true)
							{
								companymode();
								int b1 = x.nextInt();
								if (b1 == 1)
								{
									while (true)
									{
										System.out.println("Enter Company name :");
										String cname = x.next();
										System.out.println("Enter Role :");
										String crole = x.next();
										System.out.println("Enter Package Offered :");
										long csalary = x.nextLong();
										System.out.println("Enter CGPA required :");
										float cCGPA = x.nextFloat();
										
										Company c = new Company(cname , crole , csalary , cCGPA, pc);
										pc.add_initialcomp(c);
										break;
									}
								}
								
								else if (b1 == 2)
								{
									System.out.println("Choose a Company (Enter corresponding number) :");
									pc.printArrayList(pc.getinitial_companies());
//									while (true)
//									{
	
										int b11 = x.nextInt();
										while (true)
										{
											String cnm = pc.getinitial_companies().get(b11-1).getCname();
											System.out.println("Welcome, " + cnm + "!");
							
											System.out.println("1) Update Role\n"
													+ "2) Update Package\n"
													+ "3) Update CGPA criteria\n"
													+ "4) Register To Institute Drive\n"
													+ "5) Back");
											int b12 = x.nextInt();
											if (b12 == 1)
											{
												System.out.println("Enter Role :");
												String rl = x.next();
												pc.updateRole(pc.getinitial_companies().get(b11-1), rl);
												System.out.println("Role udpated Successfully !");
												System.out.println("----");
											}
											else if (b12 == 2)
											{
												System.out.println("Enter Package :");
												long pkg = x.nextLong();
												pc.getinitial_companies().get(b11-1).updateSalary(pkg);
												System.out.println("Package udpated Successfully !");
												System.out.println("----");
											}
											else if (b12 == 3)
											{
												System.out.println("Enter CGPA required :");
												float cg = x.nextFloat();
												pc.getinitial_companies().get(b11-1).updatecgpareqd(cg);
												System.out.println("CGPA criteria udpated Successfully !");
												System.out.println("----");
											}
											else if (b12 == 4)
											{
												(pc.getinitial_companies().get(b11-1)).regToPlacementdrive();
												for (int i=0;i<pc.getCompanies().size();i++)
												{
//													String nme = pc.getCompanies().get(i)
													System.out.println(pc.getCompanies().get(i).getCname());
												}
												
											}
											else if (b12 == 5)
											{
												break;
											}
										}

									}
								
								else if (b1 == 3)
								{
									pc.printArrayList(pc.getCompanies());
									System.out.println("--------");
								}
								
								else if (b1 == 4)
								{
									break;
								}
									
								}

							}
						
						else if (b == 3)
						{
							while (true)
							{
								placementcellmode();
								int b1 = x.nextInt();
								if (b1 == 1)
								{
									pc.openStudentsReg();
									
								}
								else if (b1 == 2)
								{
									pc.openCompanyReg();
									
								}
								else if (b1 == 3)
								{
									pc.regStudents();
									System.out.println("--------*****-------");
								}
								else if (b1 == 4)
								{
									pc.regCompanies();
									System.out.println("--------*****-------");
								}
								else if (b1 == 5)
								{
									System.out.println("Number of Placed students : " + pc.getPlaced().size());
									for (int i=0 ; i < pc.getPlaced().size();i++)
									{
										System.out.println("Student " + (i+1) + " :");
										System.out.println("Name of Student : " + pc.getPlaced().get(i).getSName());
										System.out.println("Roll number : " + pc.getPlaced().get(i).getSRoll());
										System.out.println("CGPA : "+ pc.getPlaced().get(i).getCGPA());
										System.out.println("Branch : " + pc.getPlaced().get(i).getSBranch());
										System.out.println("Current CTC (in LPA) : " + pc.getPlaced().get(i).getcurrentOffer());
									}
									
									System.out.println("----------");
									
									int numUnplaced=0;
									for (int i=0;i<pc.getregisteredPCstudents().size();i++)
									{
										if (pc.getregisteredPCstudents().get(i).get_isblocked() == false && pc.getregisteredPCstudents().get(i).get_isplaced() == false)
										{
											numUnplaced++;
										}
									}
									System.out.println("Number of Unplaced Students : " + numUnplaced);
									System.out.println("----------");
									
									
									int numBlocked=0;
									for (int i=0;i<pc.getregisteredPCstudents().size();i++)
									{
										if (pc.getregisteredPCstudents().get(i).get_isblocked() == true )
										{
											numBlocked++;
										}
									}
								
									System.out.println("Number of Blocked Students : " + numBlocked);
									
								}
								else if (b1 == 6)
								{
									System.out.println("Enter Student Name :");
									String na = x.next();
									System.out.println("Enter Roll no. :");
									long rol = x.nextLong();
									
									for (int i=0 ; i < pc.getregisteredPCstudents().size() ; i++)
									{	
										
											if (rol == pc.getregisteredPCstudents().get(i).getSRoll())
											{
												pc.getStudentDetails((pc.getregisteredPCstudents()).get(i) ,rol );
											}
									}
								}
								
								else if (b1 == 7)
								{
									System.out.println("Enter Company Name :");
									String na = x.next();
									
									for (int i=0 ; i < pc.getCompanies().size() ; i++)
									{
										if (na.equals(pc.getCompanies().get(i).getCname()))
										{
											pc.getCompanydetails(pc.getCompanies().get(i));
										}
									}
								}
								
								else if (b1 == 8)
								{
									pc.avgpackage();
								}
								
								else if (b1 == 9)
								{
									System.out.println("Enter Company name :");
									String cmp = x.next();
									
									for (int i=0 ; i < pc.getCompanies().size() ; i++)
									{
										if (cmp.equals(pc.getCompanies().get(i).getCname()))
										{
											pc.companyProcessResults(pc.getCompanies().get(i));
										}
									}
								}
								
								else if (b1 == 10)
								{
									break;
								}
							}
						}
						
						else if (b == 4)
						{
							break;
						}
					}
				}
				
				else if (a == 2)
				{
					System.out.println("Thank you for using Future Builder !");
					return;	
				}
//				break;
			}
		}
		
		
		else if (S.equals("Exit FutureBuilder"))
		{
			System.out.println("Thank you for using Future Builder !");
			return;
		}
	
		
		else 
		{
			System.out.println("Could not enter FutureBuilder due to unidentified input !");
		}
		
		
	}

}
