from django.shortcuts import render, HttpResponse, redirect
from accounts.custom_forms import RegisterUserForm, SignUpForm
from django.contrib.auth import login

def login_view(request):
    if request.method == 'POST':
        form = SignUpForm(data=request.POST)
        if form.is_valid():
            user = form.get_user()
            login(request, user)
            return redirect('dashboard')
        else:
            form = SignUpForm()
        return render(request, 'accounts/login.html', {'form': form})

def logout_view(request):
    if request.method == 'POST':
        logout(request)
        return redirect('landing_page')
