import { Injectable } from '@angular/core';
import { HttpClient, } from '@angular/common/http'
import { Medicine } from './medicine';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private http: HttpClient) { }

  storeMedicine(product:any):Observable<Medicine>{
    return this.http.post<Medicine>("http://localhost:8081/medicine/storeMedicine", product)
  }
   

  updateMedicine(product: any): Observable<string> {
    return this.http.patch("http://localhost:8081/medicine/updateMedicine", product, { responseType: 'text' })
  }


  loadProductDetails(): Observable<Medicine[]> {
    return this.http.get<Medicine[]>("http://localhost:8081/medicine/")
  }
  deleteMedicineById(medid:number):Observable<string> {
    return this.http.delete("http://localhost:8081/medicine"+"/"+medid,{responseType:"text"});
  }

}











  

  

  