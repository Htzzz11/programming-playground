# Two Pointers Notes

Two pointers is a pattern that uses two indices (or iterators) to traverse a sequence in a coordinated way. It is most effective when you can leverage ordering, monotonicity, or paired constraints to avoid nested loops.

## General Format

### 1) Opposite Ends (Converging)

Use when the array/string is sorted or can be sorted without losing meaning.

```text
left = 0
right = n - 1
while left < right:
    # evaluate / update answer
    if condition is too small:
        left += 1
    else:
        right -= 1
```

Common examples: 2-sum in sorted array, container with most water, palindrome checks.

### 2) Same Direction (Fast/Slow or Window)

Use when you need to track a subarray or to detect cycles/duplicates.

```text
slow = 0
for fast in range(n):
    # expand with fast
    while constraint violated:
        # shrink with slow
        slow += 1
    # update answer with [slow..fast]
```

Common examples: longest substring with constraint, remove duplicates in-place, cycle detection (fast/slow).

### 3) Multiple Arrays (Merge-like)

Use when two sorted inputs can be processed with linear scan.

```text
i = 0
j = 0
while i < n and j < m:
    if a[i] <= b[j]:
        use a[i]; i += 1
    else:
        use b[j]; j += 1
```

Common examples: merge sorted arrays, find intersection, k-th smallest across two sorted lists.

## Common Pitfalls

- Off-by-one errors on loop boundaries (`left < right` vs `left <= right`).
- Forgetting to update the answer before moving pointers.
- Moving the wrong pointer (violates monotonic reasoning).
- Sorting when order matters (e.g., “subarray” problems cannot be sorted).
- Missing duplicates handling in multi-pointer solutions (e.g., 3-sum).
- Window not fully restored after constraint violation (needs `while`, not `if`).
- Using extra memory when an in-place solution is required.

## Helpful Tips

- Always write the invariant: what is guaranteed about the region each pointer covers.
- Identify monotonicity: which pointer move improves or worsens the condition.
- For sorted arrays, decide whether a larger value needs `left++` or `right--`.
- Use `while left < right` unless you explicitly need to inspect the middle element.
- For windows, keep a running count/metric to update in O(1).
- When dealing with duplicates, skip ahead in a loop to avoid repeated work.

## When Two Pointers Applies

- The input is sorted or can be sorted without losing meaning.
- You compare pairs and can discard large ranges based on order.
- You need a linear scan with constraints on a contiguous segment.
- You want O(n) time over O(n^2) by leveraging structure.

## Decision Checklist

1) Is the input sorted or can it be sorted?
2) Can moving a pointer only improve or worsen a condition (monotonic)?
3) Is the answer based on a subarray/substring (sliding window)?
4) Can you avoid revisiting elements (single pass)?

If yes to any, two pointers is likely a good fit.

## Mini Patterns Library

### Remove Duplicates In-Place (sorted array)

```text
slow = 0
for fast in range(1, n):
    if nums[fast] != nums[slow]:
        slow += 1
        nums[slow] = nums[fast]
return slow + 1
```

### Two Sum in Sorted Array

```text
left = 0
right = n - 1
while left < right:
    s = nums[left] + nums[right]
    if s == target:
        return [left, right]
    if s < target:
        left += 1
    else:
        right -= 1
```

### Longest Substring with Constraint (example: at most K distinct)

```text
slow = 0
counts = {}
for fast in range(n):
    add s[fast]
    while distinct_count > k:
        remove s[slow]
        slow += 1
    update answer with fast - slow + 1
```

## Debugging Strategy

- Print pointer positions and key metrics after each move.
- Validate invariant at the top of each loop iteration.
- Test edge cases: empty input, one element, all same values, strictly increasing.

## Complexity Cheatsheet

- Time: usually O(n) or O(n log n) if sorting is required.
- Space: often O(1), except for window counters/maps.
