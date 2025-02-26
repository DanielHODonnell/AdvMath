For AdvMath, the scope of this project is fairly big if I want to include most formulas that you would need for an advanced math calculator.
I recognize that this is much harder to do in Java than in Python since Java doesn't have a dedicated library that helps with multidimensional arrays
and advanced math calculations.

For example, here is what taking the derivative of a function with respects to x looks like in Python:

  import sympy
  
  x = sympy.Symbol('x')
  f_sym = 2*x**2 + 3*x + 1
  
  df_dx_sym = sympy.diff(f_sym, x)
  print(f"The symbolic derivative of f(x) is: {df_dx_sym}") # Finding the derivative with respect to x.

This is significantlly simpler than Java since we can import a specific library for more advanced mathematics instead of having to hard code the derivative.
