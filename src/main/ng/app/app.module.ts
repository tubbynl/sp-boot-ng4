import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { HttpClientModule }    from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HeroDetailComponent } from './hero/hero-detail.component';
import { HeroListComponent } from './hero/hero-list.component';
import { HeroService } from './hero/hero.service';
import { DashboardComponent } from './dashboard/dashboard.component'

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    HeroDetailComponent,
    HeroListComponent,
    DashboardComponent,
  ],
  providers: [
    HeroService
  ],
  bootstrap: [
    AppComponent,
  ]
})
export class AppModule { }
