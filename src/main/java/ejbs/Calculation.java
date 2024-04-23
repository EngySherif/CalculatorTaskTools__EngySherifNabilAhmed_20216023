package ejbs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calculation {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	int ID;
	int Number1;
	int Number2;
	String Operation;
	
	public void setId(int ID)
	{
		this.ID=ID;
	}
	
	public int getId()
	{
		return ID;
	}
	
	public void setNumber1(int Number1)
	{
		this.Number1=Number1;
	}
	
	public void setNumber2(int Number2)
	{
		this.Number2=Number2;
	}
	
	public int getNumber1()
	{
		return Number1; 
	}

	public int getNumber2()
	{
		return Number2; 
	}
	
	public void setOperation(String Operation)
	{
		this.Operation=Operation;
	}
	
	public String getOperation()
	{
		return Operation;
	}
	
	public int subtract()
	{
		return Number1-Number2;
	}
	
	
	public int add()
	{
		return Number1+Number2;
	}
	
	
	public int divide()
	{
		return Number1/Number2;
	}
	
	public int multiply()
	{
		return Number1*Number2;
	}
	
	
	
	
}
