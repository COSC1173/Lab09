# Lab 09 — Array Statistics

| | |
|---|---|
| **Week** | 10 |
| **Textbook** | Liang — **Chapter 7** (Single-Dimensional Arrays) |
| **Time budget** | 60 minutes |
| **Points** | 100 |

---

## Learning Objectives

1. Traverse an array with an indexed `for` loop and with an enhanced `for` loop, and know when each applies.
2. Implement linear search.
3. Return a new array rather than modifying the caller's array, and explain why that distinction exists.
4. Reuse your own methods instead of duplicating loops.
5. Guard every method against a `null` or empty array.

---

## Background

**Arrays are objects, and array variables hold references.** This is the central idea of the lab:

```java
int[] a = {1, 2, 3};
int[] b = a;        // b refers to the SAME array; nothing was copied
b[0] = 99;          // a[0] is now 99 as well
```

A method that receives an array receives a copy of the *reference*, so writing into the array is
visible to the caller. That is why `reversed` must allocate a **new** array:

```java
int[] copy = new int[values.length];                 // a distinct array of the same size
for (int i = 0; i < values.length; i++) {
    copy[values.length - 1 - i] = values[i];         // first element becomes last
}
return copy;                                          // the caller's array is untouched
```

The test driver checks the original array *after* calling `reversed`, so an in-place reversal fails.

**Indexed versus enhanced `for`.** Use the enhanced form when you only need the values; use the
indexed form when you need the position:

```java
for (int v : values) total += v;                  // enhanced: no index available
for (int i = 0; i < values.length; i++) { ... }   // indexed: needed by indexOfMax and linearSearch
```

**Length is a field, not a method.** `values.length` for an array; `text.length()` for a `String`.

**Finding the maximum.** Start by assuming index 0 holds the maximum, then update only on a
**strictly greater** value. Using `>=` would return the *last* occurrence of a tie; the
specification requires the first.

---

## Instructions

| Step | Method | Requirement |
|---|---|---|
| 1 | `sum(int[])` | Total of all elements; 0 for `null`/empty |
| 2 | `average(int[])` | **Reuse `sum`**; divide as a `double`; 0.0 for empty |
| 3 | `indexOfMax(int[])` | Index of the **first** largest element; `-1` for empty |
| 4 | `linearSearch(int[], int)` | Index of the first match, else `-1` |
| 5 | `reversed(int[])` | A **new** reversed array; the input is unmodified |
| 6 | `countAbove(int[], double)` | Count of elements **strictly** greater than the threshold |
| 7 | `main` | Build a sample array and print each result |

**On Step 2:** write `(double) sum(values) / values.length`. Both `sum` and `length` are integers,
so without the cast Java performs integer division and `415 / 5` silently truncates in cases where
the mean is not whole.

---

## Commenting Standard (20 points)

```java
// WEAK
int[] copy = new int[values.length]; // make array

// STRONG
// A new array is allocated because array parameters are references: writing into
// values[] here would corrupt the caller's data, which the tests explicitly check.
int[] copy = new int[values.length];
```

---

## Compile, Run, and Test

```bash
bash tools/run_lab.sh lab09          # 25 official checks
python3 tools/comment_check.py labs/lab09
```

---

## Test Data

| Array | Contents |
|---|---|
| `scores` | `{88, 92, 79, 95, 61}` — sum 415, average 83.0, max at index 3 |
| `tied` | `{7, 9, 9, 3}` — the maximum appears twice; index 1 is required |
| `negatives` | `{-5, -30, -1, -12}` — max at index 2 |
| `empty` | `{}` — every method must survive it |

---

## Grading Rubric

| Criterion | Points |
|---|---|
| All 25 checks pass | 60 |
| Line comments explain every statement | 20 |
| `average` reuses `sum`; `reversed` does not mutate; empty arrays guarded | 10 |
| Committed and pushed on time | 10 |

---

## Submission Checklist

- [ ] `bash tools/run_lab.sh lab09` reports 25 of 25.
- [ ] The check "the original array was NOT modified" passes.
- [ ] No `ArrayIndexOutOfBoundsException` on any input.

```bash
git add . && git commit -m "Lab 09 complete - all 25 checks passing" && git push
```

---

## Stretch Goal

Add `public static int[] sorted(int[] values)` implementing selection sort on a **copy**, then add
`binarySearch(int[] sortedValues, int key)`. Compare the number of comparisons each search
performs on an array of 1000 elements and record the result in a comment.

---

## Troubleshooting

| Symptom | Cause | Fix |
|---|---|---|
| `ArrayIndexOutOfBoundsException: 5` | Loop condition uses `<=` | Use `i < values.length` |
| `cannot find symbol: method length()` | Called `length()` on an array | Arrays use the field `values.length` |
| Average truncated to a whole number | Integer division | Cast: `(double) sum(values) / values.length` |
| "original array was NOT modified" fails | Reversed in place | Allocate a new array |
| Tie returns index 2 instead of 1 | Used `>=` when comparing | Use `>` |

