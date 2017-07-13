import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { RouterModule }   from '@angular/router';

import { AppComponent } from './app.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';
import { HeroListComponent } from './hero-list/hero-list.component';
import { HeroService } from './hero.service';
import { DashboardComponent } from './dashboard/dashboard.component'

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot([
      {
        path: '',
        redirectTo: '/dashboard',
        pathMatch: 'full'
      },
      {
        path: 'heroes',
        component: HeroListComponent
      },
      {
        path: 'dashboard',
        component: DashboardComponent
      }
    ])
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
