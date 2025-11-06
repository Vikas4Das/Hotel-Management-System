import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import CryptoJS from 'crypto-js';

@Injectable({
  providedIn: 'root',
})
export class ApiService {

  
  private static BASE_URL = 'http://localhost:8081/api';
  private static ENCRYPTION_KEY = 'dennis-encryp-key';

  constructor(private http: HttpClient) {}


  encryptAndSaveToStorage(key: string, value: string): void {
    const encryptedValue = CryptoJS.AES.encrypt(
      value,
      ApiService.ENCRYPTION_KEY
    ).toString();
    localStorage.setItem(key, encryptedValue);
  }

  private getFromStorageAndDecrypt(key: string): string | null {
    try {
      const encryptedValue = localStorage.getItem(key);
      if (!encryptedValue) return null;
      return CryptoJS.AES.decrypt(
        encryptedValue,
        ApiService.ENCRYPTION_KEY
      ).toString(CryptoJS.enc.Utf8);
    } catch {
      return null;
    }
  }


  setLoginStatus(isLoggedIn: boolean): void {
    localStorage.setItem('isLoggedIn', isLoggedIn ? 'true' : 'false');
  }

  isAuthenticated(): boolean {
    return localStorage.getItem('isLoggedIn') === 'true';
  }


  private clearAuth(): void {
    localStorage.removeItem('isLoggedIn');
    localStorage.removeItem('role');
  }



  registerUser(body: any): Observable<any> {
    return this.http.post(`${ApiService.BASE_URL}/auth/register`, body);
  }

  loginUser(body: any): Observable<any> {
    return this.http.post(`${ApiService.BASE_URL}/auth/login`, body);
  }

  logout(): void {
    this.clearAuth();
  }

 

  myProfile(): Observable<any> {
    return this.http.get(`${ApiService.BASE_URL}/users/account`);
  }

  myBookings(): Observable<any> {
    return this.http.get(`${ApiService.BASE_URL}/users/bookings`);
  }

  deleteAccount(): Observable<any> {
    return this.http.delete(`${ApiService.BASE_URL}/users/delete`);
  }



  addRoom(formData: any): Observable<any> {
    return this.http.post(`${ApiService.BASE_URL}/rooms/add`, formData);
  }

  updateRoom(formData: any): Observable<any> {
    return this.http.put(`${ApiService.BASE_URL}/rooms/update`, formData);
  }

  getAvailableRooms(
    checkInDate: string,
    checkOutDate: string,
    roomType: string
  ): Observable<any> {
    return this.http.get(`${ApiService.BASE_URL}/rooms/available`, {
      params: { checkInDate, checkOutDate, roomType },
    });
  }

  getRoomTypes(): Observable<any> {
    return this.http.get(`${ApiService.BASE_URL}/rooms/room-types`);
  }

  getAllRooms(): Observable<any> {
    return this.http.get(`${ApiService.BASE_URL}/rooms/all`);
  }

  getRoomById(roomId: string): Observable<any> {
    return this.http.get(`${ApiService.BASE_URL}/rooms/${roomId}`);
  }

  deleteRoom(roomId: string): Observable<any> {
    return this.http.delete(`${ApiService.BASE_URL}/rooms/delete/${roomId}`);
  }

 

  bookRoom(booking: any): Observable<any> {
    return this.http.post(`${ApiService.BASE_URL}/bookings`, booking);
  }

  getAllBookings(): Observable<any> {
    return this.http.get(`${ApiService.BASE_URL}/bookings/all`);
  }

  updateBooking(booking: any): Observable<any> {
    return this.http.put(`${ApiService.BASE_URL}/bookings/update`, booking);
  }

  getBookingByReference(bookingCode: string): Observable<any> {
    return this.http.get(`${ApiService.BASE_URL}/bookings/${bookingCode}`);
  }

 

  proceedForPayment(body: any): Observable<any> {
    return this.http.post(`${ApiService.BASE_URL}/payments/pay`, body);
  }

  updateBookingPayment(body: any): Observable<any> {
    return this.http.put(`${ApiService.BASE_URL}/payments/update`, body);
  }

 

  getUserRole(): string | null {
    return this.getFromStorageAndDecrypt('role');
  }

  isAdmin(): boolean {
    return this.getUserRole() === 'ADMIN';
  }

  isCustomer(): boolean {
    return this.getUserRole() === 'CUSTOMER';
  }
} 