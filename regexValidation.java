package project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class regexValidation  extends Throwable { 
	String exString;
	public regexValidation() {
		exString="";
	}
	regexValidation(String exString){
		this.exString=exString;
	}
	public boolean regexvalid (Student object) throws regexValidation{
		//Firstname and Lastname
		String regexString = "([a-zA-Z]{3,30}\\s*)+";
		Pattern r = Pattern.compile(regexString);
		Matcher m = r.matcher(object.firstname+" "+object.lastname);
		Boolean bool = new Boolean(m.find());
		if(bool==false) {
			//Throw Execution
			throw new regexValidation("Invalid Name Parameter");
		}
		
		//Register Number
		regexString = "^([0-9]{2}(EU|eu)*[A-Za-z]{2}[0-9]{3})$";
		r = Pattern.compile(regexString);
		m = r.matcher(object.regno);
		bool = new Boolean(m.find());
		if(bool==false) {
			//Throw Execution
			throw new regexValidation("Invalid Register Number Parameter");

		}

		//Email ID
		regexString = "^[0-9]{2}(EU|eu)*[A-Za-z]{2}[0-9]{3}@?skcet\\.ac\\.in$";
		r = Pattern.compile(regexString);
		m = r.matcher(object.email);
		bool = new Boolean(m.find());
		if(bool==false) {
			//Throw Execution
			throw new regexValidation("Invalid Email ID Parameter");

		}
		
		/*//Date of Birth
		regexString = "^(0[1-9]|1[012])[- /.] (0[1-9]|[12][0-9]|3[01])[- /.] (19|20)\\d\\d$";
		r = Pattern.compile(regexString);
		m = r.matcher(student.dob);
		bool = new Boolean(m.find());
		if(bool==false) {
			//Throw Execution
			throw new regexValidation("Invalid Date of Birth \n Make Sure you have Entered in YYYY-MM-DD");

		}*/
		
		//Phonenumber
		regexString = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$";
		r = Pattern.compile(regexString);
		m = r.matcher(object.phonenumber);
		bool = new Boolean(m.find());
		if(bool==false) {
			//Throw Execution
			throw new regexValidation("Invalid Phone Parameter");

		}
		return true;
	}
		public boolean regexvalid (Advisor object) throws regexValidation{
			//Firstname and Lastname
			String regexString = "([a-zA-Z]{3,30}\\s*)+";
			Pattern r = Pattern.compile(regexString);
			Matcher m = r.matcher(object.firstname+" "+object.lastname);
			Boolean bool = new Boolean(m.find());
			if(bool==false) {
				//Throw Execution
				throw new regexValidation("Invalid Name Parameter");
			}
			
			//Email ID
			regexString = "^([a-zA-Z0-9_\\-\\.]+)@?skcet\\.ac\\.in$";
			r = Pattern.compile(regexString);
			m = r.matcher(object.email);
			bool = new Boolean(m.find());
			if(bool==false) {
				//Throw Execution
				throw new regexValidation("Invalid Email ID Parameter");

			}
			
			//Phonenumber
			regexString = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$";
			r = Pattern.compile(regexString);
			m = r.matcher(object.phonenumber);
			bool = new Boolean(m.find());
			if(bool==false) {
				//Throw Execution
				throw new regexValidation("Invalid Phone Parameter");

			}
	return true;
	}
}
