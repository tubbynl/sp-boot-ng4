import { Component } from '@angular/core'
import { HelloService } from './services/hello.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [HelloService]
})
export class AppComponent {
  title = 'Tour of Heroes';
  hero = 'Windstorm';
}
