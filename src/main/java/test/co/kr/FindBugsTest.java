package test.co.kr;

//Rule#38 DuplicateImports
import java.io.*;
//Rule#21 ImportFromSamePackage
import test.co.kr.*;

import java.text.SimpleDateFormat;

public class FindBugsTest {
	//Rule#1
	public void avoidthrowingnullpointerexception(){
		throw new NullPointerException();
	}

	//Rule#2
	public void avoidthrowingrawexceptiontypes() throws Exception {
		throw new Exception();
	}
	
    //Rule#3
    public String equalsnull(){
        String x = "foo";
        if (x.equals(null)) {
            return "is null";
        }
        return x;
    }

	//Rule#4
	public int variable_naming_conventions = 7;
    
	public String changeValue(){
		return Integer.toString(variable_naming_conventions);
	}
	
    //Rule#5
    public int avoidreassigningparameters(String bar){
    	 bar = "something else";
    	 return 0;
    }
 	
	//Rule#6
	public String stringinstantiation(){
		return new String("String Instantiation");
	}

    //Rule#7
	static abstract class AbstractClassWithoutAbstractMethod{
		
	}
	
	//Rule#8 => check¾ÈµÊ
	public int assignmentinoperand(){
       int x = 2;
        if ( (x = getX()) == 3) {
        	return x;
        }        
        return x+1;
	}
	
    private int getX() {
        return 3;
    }
    
    //Rule#9
    static int assignmenttononfinalstatic;
    
    public FindBugsTest(int y){
    	assignmenttononfinalstatic = y;
    }
    
    public boolean checkrule9(){
    	if(1 == assignmenttononfinalstatic)
    		return true;

    	return false;
    }
    
	//Rule#10
	public int[] avoidarrayloops(){
		int[] a = new int[10];
		int[] b = new int[10];
		for (int i=0;i<10;i++) {
		    b[i]=a[i];
		}
		
		return b;
	}

	//Rule#11 => check¾ÈµÊ
	interface AvoidConstantsInterface {
	    public static int CONSTANT1 = 0;
	    public static String CONSTANT2 = "1";
	}
    
    //Rule#12
    synchronized String avoidsynchronizedatmethodlevel(){
    	int test = 1;
    	return String.valueOf(test);
    }
	
	//Rule#13
    public static final String PATH="text";
    
	public void emptycatchblock(){
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(PATH);
		}catch (IOException ioe){
		    //
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Rule#14
	public void emptyfinallyblock(){
        try
        {
            int x=3;
        }
        finally
        {
            //
        }
	}
	
	//Rule#15
	public void emptyifstmt(int x){
        if (x == 1) {
            //
        }
	}

	//Rule#16
	public void emptystatementnotinloop(){
		;
	}
	
	//Rule#17
	public void emptytryblock(){
        try 
        {
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
	
	//Rule#18
	public void emptywhilestmt(int a, int b){
        while (a == b) {
            //
        }
	}
	
    //Rule#19
    public final int FINAL_FIELD_COULDBESTATIC = 42;

	//Rule#20 => check¾ÈµÊ
    private String immutablefield;
    
    public FindBugsTest(String str){
    	immutablefield = str;
    	
    }
    
    public String getStr(){
    	return immutablefield;
    }
	
    //Rule#21 »ó´Ü¿¡ ImportFromSamePackage
    
	//Rule#22
	public String inefficientemptystringcheck(String msg){
		if (msg != null && msg.trim().length() > 0) {
		    return "A";
		}
		return "B";
	}

	//Rule#23
	public StringBuffer inefficientstringbuffering(){
//		StringBuffer sb = new StringBuffer( "tmp =" +  
//                System.getProperty("java.io.tmpdir") );
		return new StringBuffer( "tmp =" +  
                System.getProperty("java.io.tmpdir") );
	}    

	//Rule#24
	public int misleadingvariablename(){
		int m_biz = 42;
		return m_biz;
	}

	//Rule#25
    public SimpleDateFormat simpledataformatneedslocale(){
    	return new SimpleDateFormat("pattern");
    }

	//Rule#26
    public boolean bar = (simplifybooleanexpressions() == true);
    
    public boolean simplifybooleanexpressions() {
        return false;
    }
    
    public String useBar(){
    	return Boolean.toString(bar);
    }

	//Rule#27
	public String stringtostring(){
		String str = "stringtostring";
		return str.toString();
	}

    //Rule#28
    public int switchstmtsshouldhavedefault(){
		int x = 2;
		switch (x) {
		    case 2:
		    x = 8;
		}
		return x;
    }

	//Rule#29
	public void uncommentedemptymethod(){
	}

	//Rule#30
	public String unnecessaryconversiontemporary(int x){
	    return new Integer(x).toString();
	}

    //Rule#31
    public boolean unnecessaryparentheses(){
    	return (true);
    }

	//Rule#32
	public int unnecessarywrapperobjectcreation(String s){
		return Integer.valueOf(s).intValue();
	}
	
	//Rule#33
	private String unusedformalparameter(String hi){
		return "unusedformalparameter";
	}

	public void unusedformalparameter_test(){
		unusedformalparameter("hi");
	}
	
    //Rule#34
	private int unusedprivatefield;
	
	//Rule#35
	private String unusedprivatemethod(){
		return "hi";
	}
	
	//Rule#36
	public String uselessstringvalueof(int i) {
	    String s;
	    s = "a" + String.valueOf(i);
	    return s;
	}

	//Rule#37
	public String whileloopsmustusebraces(){
		int x = 5;
		
		while (x > 5)
		   String.valueOf(x++);
		
		return String.valueOf(x);
	}
	
	public static void main(String[] args) {
		//Rule#39
		System.out.println("egov pmd rules test=>SystemPrintln");
	}
}


