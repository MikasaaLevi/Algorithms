package com.union.find;

import java.util.Arrays;
import java.util.Scanner;

public class WeightedQuickUnion {
	int id[];
	int size[];
	WeightedQuickUnion(int N){
		this.id=new int[N];
		this.size=new int[N];
		Arrays.fill(size,0);
		for(int i=0;i<id.length;i++) {
			id[i]=i;
		}
	}
	public void union(int p,int q) {
		int proot=root(p);
		int qroot=root(q);
		if(proot==qroot)
			return;
		if(size[proot]>size[qroot]) {
			id[qroot]=proot;
			size[proot]++;
		}
		else {
			id[proot]=qroot;
			size[qroot]++;
		}
	}
	public int root(int i) {
		while(i!=id[i])
			i=id[i];
		return i;
	}
	public boolean connected(int p,int q)
	{
		return root(p)==root(q);
	}
	public static void main(String[] args) {
		System.out.println("Invoking main in WeightedQuickUnion");
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		WeightedQuickUnion uf = new WeightedQuickUnion(N);
		 char c=' ';
		 do
		 {
		 int p = scanner.nextInt();
		 int q = scanner.nextInt();
		 if (!uf.connected(p, q))
		 {
		 uf.union(p, q);
		 System.out.println(p + " " + q);
		 }
		 else
			 System.out.println("connected");
		 System.out.println("Enter Y or y to continue");
		 c=scanner.next().charAt(0);
		 }while (c=='Y'||c=='y');
		scanner.close();
	}
}
