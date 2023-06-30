import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegisterModel } from '../register/register-model';
import { LoginModel } from '../login/login-model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }


//method to check if the user is login
login(loginData:LoginModel):Observable<any>{
  return this.http.post<any>('http://localhost:9192/api/v1/login',loginData);
}




}
