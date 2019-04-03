//sakib  khan
public class GlassFalling {
	public int max(int x,  int y){
		return (x>y)?x:y;
	}
// Do not change the parameters!
public int glassFallingRecur(int floors, int sheets) {
if(sheets==1|| sheets==0)
	
return sheets;
if(floors==1)
	return sheets;
int min=Integer.MAX_VALUE;
int x, res;
for(x=1;x<=sheets;x++){
	res=Math.max(glassFallingRecur(floors-1,x-1),glassFallingRecur(floors,sheets-x));
	if(res<min)
		min=res;
}
return min +1;
}
// Optional:
// Pick whatever parameters you want to, just make sure to return an int.
public int glassFallingMemoized() {
// Fill in here and change the return
return 0;
}
// Do not change the parameters!

public int glassFallingBottomUp(int floors, int sheets) {
	int sheetss[][]=new int [floors+1][sheets+1];
	int res;
	int i,j,x;
	for( i=1;i<=floors;i++){
		sheetss[i][1]=1;
		sheetss[i][0]=0;
	}
	for(j=1;j<=sheets;j++)
		sheetss[1][j]=j;
	for(i=2;i<=floors;i++){
		for(j=2;j<=sheets;j++){
			sheetss[i][j]=Integer.MAX_VALUE;
			for(x=1;x<=j;x++){
				res=1+ max (sheetss[i-1][x-1],sheetss[i][j-x]);
				if(res<sheetss[i][j])
					sheetss[i][j]=res;
			}
		}
	}

return sheetss[floors][sheets];
}
public static void main(String args[]){
GlassFalling gf = new GlassFalling();
// Do not touch the below lines of code, and make sure
// in your final turned-in copy, these are the only things printed
int minTrials1Recur = gf.glassFallingRecur(27, 2);
int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
int minTrials2Recur = gf.glassFallingRecur(100, 3);
int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
System.out.println(minTrials1Recur + " " + minTrials1Bottom);
System.out.println(minTrials2Recur + " " + minTrials2Bottom);
}
}
