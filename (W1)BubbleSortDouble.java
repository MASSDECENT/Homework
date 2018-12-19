/**
@Adisak Sammarungrojh 5907401004
 * */
package th.ac.utcc.cpe.Adisak;

	public class BubbleSortDouble {
		private double [] element ;
		private int eSize ;
		public BubbleSortDouble(int size){
			if(size < 0)
				this.element = new double [size];
		else
			this.element = new double [10];
			eSize = 0;
		}

		public void insert(double e){
			this.element[eSize] = e ;
				eSize++ ;
		}

		public void show(){
			for(int i =0 ; i < eSize ; i++){
				System.out.print(this.element[i]+" // ");
			}
				System.out.println(" ");
		}

		public void bubbleSort(){
			int out, in;
		for(out = eSize - 1; out>0; out--){
			for(in  = 0 ; in< out; in++){
				if(this.element[in]< this.element[in+1]){
					this.swap(in,in+1);
				}
			}
		}
	}
		
		private void swap(int left , int right){
				double temp = this.element[right];
				this.element[right] = this.element[left] ;
				this.element[left] = temp ;

	}

		public static void main (String[] args){
			int max = 20 ;
				BubbleSortArray bubble = new BubbleSortArray(max);
					bubble.insert(87);
					bubble.insert(43);
					bubble.insert(95);
					bubble.insert(32);
					bubble.insert(91);
					bubble.insert(78);
					bubble.insert(26);
					bubble.insert(12);
		System.out.print("Original Order: ");
			bubble.show();
			bubble.bubbleSort();
		System.out.print("Sorted Order: ");
			bubble.show();
		}
	}
