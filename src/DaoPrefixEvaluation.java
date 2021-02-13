//Jason Dao ACSL #4
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class DaoPrefixEvaluation {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner (new File("C:\\Users\\Jason Dao\\Documents\\Eclipse Workspace\\Dao's Prefix Evaluation\\Input"));
		for (int x=0; x<5;x++)
		{
			ArrayList<Integer>prefix=new ArrayList<Integer>();
			String r=s.nextLine();
			prefix=input(r);
			while (prefix.size() !=1)
			{
				prefix=checkadd(prefix);
				prefix=checksubtract(prefix);
				prefix=checkmultiply(prefix);
				prefix=checkmax(prefix);
				prefix=checkabs(prefix);
				prefix=checkswitcher(prefix);
			}
			System.out.println(prefix.get(0));
		}
}
public static ArrayList<Integer> input(String r)
{
	ArrayList <Integer>n=new ArrayList<Integer>();
	String t="";
	for (int i=0;i<r.length();i++)
	{
		t=r.substring(i,i+1);
		if (t.equals("*"))
		{
			n.add(1001);
		}
		else if (t.equals("+"))
		{
			n.add(1002);
		}
		else if (t.equals("-") && r.substring(i+1, i+2).equals(" "))
		{
			n.add(1003);
		}
		else if (t.equals("|"))
		{
			n.add(1004);
		}
		else if (t.equals("@"))
		{
			n.add(1005);
		}
		else if (t.equals(">"))
		{
			n.add(1006);
		}
		else if (t.equals(" "))
		{
			continue;
		}
		else if (t.equals("-") && i+1<r.length() && !(r.substring(i+1, i+2).equals(" ")))
		{
			String q=r.substring(i+1, i+2);
			int f=1;
			if (i+2<r.length() && !(r.substring(i+2, i+3).equals(" ")))
			{
				f++;
				q+=r.substring(i+2, i+3);
				if (i+3<r.length() && !r.substring(i+3, i+4).equals(" "))
				{
					f++;
					q+=r.substring(i+3, i+4);
					if (i+4<r.length() && !r.substring(i+4, i+5).equals(" "))
					{
						f++;
						q+=r.substring(i+4, i+5);
					}
				}
			}
			int j=Integer.parseInt(q);
			n.add(-j);
			for (int m=0;m<f;m++)
			{
				i++;
			}
		}		
		else
		{
			String q=t;
			int f=1;
			if (i+1<r.length() && !r.substring(i+1, i+2).equals(" "))
			{
				f++;
				q+=r.substring(i+1, i+2);
				if (i+2<r.length() && !r.substring(i+2, i+3).equals(" "))
				{
					f++;
					q+=r.substring(i+2, i+3);
					if (i+3<r.length() && !r.substring(i+3, i+4).equals(" "))
					{
						f++;
						q+=r.substring(i+3, i+4);
					}
				}
			}
			int h=Integer.parseInt(q);
			n.add(h);
			for (int m=0;m<f;m++)
			{
				i++;
			}
		}
	}
	return n;
}
public static ArrayList<Integer>checkadd(ArrayList<Integer> n)
{
	for (int i=0; i<n.size();i++)
	{
		if (n.get(i)== 1002 && n.get(i+1) <=1000 && n.get(i+1)>=-1000 && n.get(i+2) <=1000 && n.get(i+2)>=-1000)
		{
			n.set(i,(n.get(i+1)+ n.get(i+2)));
			n.remove(i+1);
			n.remove(i+1);
		}
	}
	return n;
}
public static ArrayList<Integer>checksubtract(ArrayList<Integer> n)
{
	for (int i=0; i<n.size();i++)
	{
		if (n.get(i)== 1003 && n.get(i+1) <=1000 && n.get(i+1)>=-1000 && n.get(i+2) <=1000 && n.get(i+2)>=-1000 )
		{
			n.set(i,(n.get(i+1)- n.get(i+2)));
			n.remove(i+1);
			n.remove(i+1);
		}
	}
	return n;
}
public static ArrayList<Integer>checkmultiply(ArrayList<Integer> n)
{
	for (int i=0; i<n.size();i++)
	{
		if (n.get(i)== 1001 && n.get(i+1) <=1000 && n.get(i+1)>=-1000 && n.get(i+2) <=1000 && n.get(i+2)>=-1000)
		{
			n.set(i,(n.get(i+1)* n.get(i+2)));
			n.remove(i+1);
			n.remove(i+1);
		}
	}
	return n;
}
public static ArrayList<Integer>checkabs(ArrayList<Integer> n)
{
	for (int i=0; i<n.size();i++)
	{
		if (n.get(i)== 1004 && n.get(i+1) <=1000 && n.get(i+1)>=-1000)
		{
			n.set(i,(Math.abs(n.get(i+1))));
			n.remove(i+1);
		}
	}
	return n;
}
public static ArrayList<Integer>checkmax(ArrayList<Integer> n)
{
	for (int i=0; i<n.size();i++)
	{
		if (n.get(i)== 1006 && n.get(i+1) <=1000 && n.get(i+1)>=-1000 && n.get(i+2) <=1000 && n.get(i+2)>=-1000 && n.get(i+3) <=1000 && n.get(i+3)>=-1000)
		{
			int r=Math.max(n.get(i+1), n.get(i+2));
			int j=Math.max(r, n.get(i+3));
			n.set(i,j);
			n.remove(i+1);
			n.remove(i+1);
			n.remove(i+1);
		}
	}
	return n;
}
public static ArrayList<Integer>checkswitcher(ArrayList<Integer> n)
{
	for (int i=0; i<n.size();i++)
	{
		if (n.get(i)== 1005 && n.get(i+1) <=1000 && n.get(i+1)>=-1000 && n.get(i+2) <=1000 && n.get(i+2)>=-1000 && n.get(i+3) <=1000 && n.get(i+3)>=-1000)
		{
			if (n.get(i+1)>0)
			{
				n.set(i,n.get(i+2));
				n.remove(i+1);
				n.remove(i+1);
				n.remove(i+1);
			}
			else
			{
				n.set(i,n.get(i+3));
				n.remove(i+1);
				n.remove(i+1);
				n.remove(i+1);
			}
		}
	}
	return n;
}
}
