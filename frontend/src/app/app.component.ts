import { Component } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

interface CostCalculationResponse {
  id: number;
  baseConstructionCost: number;
  permitFee: number;
  utilityFee: number;
  inspectionFee: number;
  totalCost: number;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, CurrencyPipe],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  loading = false;
  error = '';
  result: CostCalculationResponse | null = null;

  form = this.fb.nonNullable.group({
    landArea: [300, [Validators.required, Validators.min(1)]],
    buildingArea: [180, [Validators.required, Validators.min(1)]],
    floors: [2, [Validators.required, Validators.min(1)]],
    constructionCostPerSqm: [1600, [Validators.required, Validators.min(1)]],
    permitRate: [0.03, [Validators.required, Validators.min(0)]],
    utilityFee: [8000, [Validators.required, Validators.min(0)]],
    inspectionFee: [2500, [Validators.required, Validators.min(0)]]
  });

  constructor(
    private readonly fb: FormBuilder,
    private readonly http: HttpClient
  ) {}

  calculate(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    this.loading = true;
    this.error = '';
    this.result = null;

    this.http.post<CostCalculationResponse>('/api/costs/calculate', this.form.getRawValue())
      .subscribe({
        next: (result) => {
          this.result = result;
          this.loading = false;
        },
        error: () => {
          this.error = 'Calculation failed. Please confirm that the backend and database are running.';
          this.loading = false;
        }
      });
  }
}
